package com.company.general.kotlin


class Boggle {
    companion object {

        @JvmStatic
        fun main(args: Array<String>) {

            val boggle = arrayOf(arrayOf('G', 'I', 'Z'), arrayOf('U', 'E', 'K'), arrayOf('Q', 'S', 'E'))
//            val dictionary = arrayOf("GEEKS", "FOR", "QUIZ", "GUQ", "EE")
            val dictionary = arrayOf("GEEKS", "FOR", "QUIZ", "GO")


            val row = boggle.size
            var col = 0
            println("$row")
            if (row > 0) col = boggle[0].size
            println("$col")

            findWordsForBoggle(boggle, dictionary, row, col)

        }


        private fun findWordsForBoggle(boggle: Array<Array<Char>>, dictionary: Array<String>, row: Int, col: Int) {
            for (word in dictionary) {
            val hasVisited: Array<BooleanArray> = Array(row) { BooleanArray(col) }
                val charInWordArray = word.toCharArray()
                if (checkWordInBoggle(charInWordArray, boggle, hasVisited)) {
                    println(word)
                }
            }
        }

        private fun checkWordInBoggle(
            charInWordArray: CharArray,
            boggle: Array<Array<Char>>,
            hasVisited: Array<BooleanArray>
        ): Boolean {
            for (char in charInWordArray) {
                if (!checkIfCharacterIsInBoggle(boggle, char, hasVisited)) return false
            }
            return true
        }

        private fun checkIfCharacterIsInBoggle(
            boggle: Array<Array<Char>>,
            char: Char,
            hasVisited: Array<BooleanArray>
        ): Boolean {
            for (i in boggle.indices) {
                for (j in boggle[i].indices) {
                    if (char == boggle[i][j] && !hasVisited[i][j]) {
                        hasVisited[i][j] = true
                        return true
                    }
                }
            }
            return false
        }


        // A recursive function to print all words present on boggle
//        fun findWordsUtil(
//            boggle: Array<CharArray>, visited: Array<BooleanArray>, i: Int,
//            j: Int, str: String
//        ) {
//            // Mark current cell as visited and append current character
//            // to str
//            var str = str
//            visited[i][j] = true
//            str = str + boggle[i][j]
//
//            // If str is present in dictionary, then print it
//            if (isWord(str)) println(str)
//
//            // Traverse 8 adjacent cells of boggle[i][j]
//            var row = i - 1
//            while (row <= i + 1 && row < M) {
//                var col = j - 1
//                while (col <= j + 1 && col < N) {
//                    if (row >= 0 && col >= 0 && !visited[row][col]) findWordsUtil(boggle, visited, row, col, str)
//                    col++
//                }
//                row++
//            }
//
//            // Erase current character from string and mark visited
//            // of current cell as false
//            str = "" + str[str.length - 1]
//            visited[i][j] = false
//        }


        // Prints all words present in dictionary.
//        fun findWords(boggle: Array<CharArray?>?) {
//            // Mark all characters as not visited
//            val visited = Array(M) { BooleanArray(N) }
//
//            // Initialize current string
//            val str = ""
//
//            // Consider every character and look for all words
//            // starting with this character
//            for (i in 0 until M) for (j in 0 until N) findWordsUtil(boggle, visited, i, j, str)
//        }
    }
}