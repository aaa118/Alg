package com.company.leetcode.kotlin.graph.medium

import java.util.*
import kotlin.math.max
import kotlin.math.min

/**
 * https://leetcode.com/problems/walls-and-gates/description/
 *
 * You are given an m x n grid rooms initialized with these three possible values.
 *
 * -1 A wall or an obstacle.
 * 0 A gate.
 * INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume
 * that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 *
 * EX: 1
 * Input: rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
 * Output: [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
 *
 * EX: 2
 * Input: rooms = [[-1]]
 * Output: [[-1]]
 */
class WallsAndGates {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val arrayOfIntArray1 = arrayOf(
                intArrayOf(2147483647,-1,0,2147483647),
                intArrayOf(2147483647,2147483647,2147483647,-1),
                intArrayOf(2147483647,-1,2147483647,-1),
                intArrayOf(0,-1,2147483647,2147483647)
            )
            println(wallsAndGates(arrayOfIntArray1))
        }

        private fun wallsAndGates(rooms: Array<IntArray>) {
            val r = rooms.size
            val c = rooms[0].size
            val q = LinkedList<Pair<Int, Int>>()
            var dist = 0
            val set = mutableSetOf<Pair<Int, Int>>()
            for (i in 0 until r) {
                for (j in 0 until c) {
                    if (rooms[i][j] == 0) {
                        q.add(Pair(i, j))
                        set.add(Pair(i, j))
                    }
                }
            }

            fun bfs(i: Int, j: Int) {
                if (i < 0 || i >= r || j< 0 || j >= c || rooms[i][j] == -1 || set.contains(Pair(i, j))) return
                set.add(Pair(i, j))
                q.add(Pair(i, j))
            }

            while (q.isNotEmpty()) {
                for (k in 0 until q.size) {
                    val (i, j) = q.pop()
                    rooms[i][j] = dist
                    bfs(i + 1, j)
                    bfs(i - 1, j)
                    bfs(i, j + 1)
                    bfs(i, j - 1)
                }
                dist++
            }
            println(rooms[0].toList().toString())
        }
    }
}