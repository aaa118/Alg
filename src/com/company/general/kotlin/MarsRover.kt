package com.company.general.kotlin

class MarsRover {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            // Expected Output (1 3 N, 5 1 E)

            println(initialInput("55",
                "12N", "LMLMLMLMM",
                "33E", "MMRMMRMRRM"))

        }


        private fun initialInput(upperRightCo: String,
                                 startPositionFirstRover: String,
                                 instructionFirstRover: String,
                                 startPositionSecondRover: String,
                                 instructionSecondRover: String): Pair<String, String> {

             var xp1: Int = startPositionFirstRover[0].toString().toInt()
             var yp1 = startPositionFirstRover[1].toString().toInt()
             var d1 = startPositionFirstRover[2].toString()

             var xp2: Int = startPositionSecondRover[0].toString().toInt()
             var yp2 = startPositionSecondRover[1].toString().toInt()
             var d2 = startPositionSecondRover[2].toString()


            val triple = moveRover(instructionFirstRover, d1, yp1, xp1)
            val triple2 = moveRover(instructionSecondRover, d2, yp2, xp2)
            d1 = triple.first
            xp1 = triple.second
            yp1 = triple.third
            d2 = triple2.first
            xp2 = triple2.second
            yp2 = triple2.third
            return Pair("$xp1 $yp1 $d1", "$xp2 $yp2 $d2")

        }

        private fun moveRover(instructionFirstRover: String, d: String, yp: Int, xp: Int): Triple<String, Int, Int> {
            var d11 = d
            var yp11 = yp
            var xp11 = xp
            for (i in instructionFirstRover) {
                when (i) {
                    'M' -> when (d11) {
                            "N" -> yp11++
                            "W" -> xp11--
                            "E" -> xp11++
                            else -> yp11--
                        }
                    'L' -> d11 = rotateLeft(d11)
                    else -> d11 = rotateRight(d11)
                }
            }
            return Triple(d11, xp11, yp11)
        }

        private fun rotateRight(d: String): String {
            return when (d) {
                "N" -> "E"
                "W" -> "N"
                "S" -> "W"
                else -> "S"
            }
        }
        private fun rotateLeft(d: String): String {
            return when (d) {
                "N" -> "W"
                "W" -> "S"
                "S" -> "E"
                else -> "N"
            }
        }
    }
}