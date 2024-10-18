package com.company.leetcode.kotlin.arrayandstrings.medium


/**
 * https://leetcode.com/problems/walking-robot-simulation/description/?envType=daily-question&envId=2024-09-04
 */
class WalkingRobotSimulation {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        enum class Direction {
            NORTH, SOUTH, EAST, WEST
        }

        fun robotSim(commands: IntArray, obstacles: Array<IntArray>): Int {
            var maxDistance = 0
            var x = 0
            var y = 0
            var direction = Direction.NORTH
            val obstacleSet = obstacles.map { Pair(it[0], it[1]) }.toSet()
            commands.forEachIndexed { commandIndex, commandId ->
                if (commandId == -2) {
                    direction = rotateLeft90Degrees(direction)
                } else if (commandId == -1) {
                    direction = rotateRight90Degrees(direction)
                } else if (commandId > 0) {
                    var moveCount = commandId
                    when (direction) {
                        Direction.NORTH -> {
                            while (moveCount > 0 && Pair(x, y + 1) !in obstacleSet) {
                                y++
                                moveCount--
                            }
                        }

                        Direction.SOUTH -> {
                            while (moveCount > 0 && Pair(x, y - 1) !in obstacleSet) {
                                y--
                                moveCount--
                            }
                        }

                        Direction.EAST -> {
                            while (moveCount > 0 && Pair(x + 1, y) !in obstacleSet) {
                                x++
                                moveCount--
                            }
                        }

                        Direction.WEST -> {
                            while (moveCount > 0 && Pair(x - 1, y) !in obstacleSet) {
                                x--
                                moveCount--
                            }
                        }
                    }
                    val newDistance = distanceSquared(0, 0, x, y)
                    if (newDistance > maxDistance) {
                        maxDistance = newDistance
                    }

                } else {
                    throw IllegalStateException("invalid command id $commandId")
                }
            }

            return maxDistance
        }

        fun rotateRight90Degrees(direction: Direction): Direction {
            return when (direction) {
                Direction.NORTH -> Direction.EAST
                Direction.EAST -> Direction.SOUTH
                Direction.SOUTH -> Direction.WEST
                Direction.WEST -> Direction.NORTH
                else -> throw IllegalStateException()
            }
        }

        fun rotateLeft90Degrees(direction: Direction): Direction {
            return when (direction) {
                Direction.NORTH -> Direction.WEST
                Direction.WEST -> Direction.SOUTH
                Direction.SOUTH -> Direction.EAST
                Direction.EAST -> Direction.NORTH
                else -> throw IllegalStateException()
            }
        }

        fun distanceSquared(x0: Int, y0: Int, x1: Int, y1: Int): Int {
            val xDiff = x0 - x1
            val yDiff = y0 - y1
            return xDiff * xDiff + yDiff * yDiff
        }
    }

}