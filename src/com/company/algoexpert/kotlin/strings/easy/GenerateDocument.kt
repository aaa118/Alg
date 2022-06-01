package com.company.algoexpert.kotlin.strings.easy

class GenerateDocument {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }


        fun generateDocument(characters: String, document: String): Boolean {
            // Write your code here.
            val hashMap = mutableMapOf<Char, Int>()
            if (document == "") return true
            //O(n)
            for (i in characters.indices) {
                val ch = characters[i]
                if (ch in hashMap) {
                    val v = hashMap[ch]!! + 1
                    hashMap[ch] = v
                } else {
                    hashMap[ch] = 1
                }
            }

            for (i in document.indices) {
                val ch = document[i]
                if (ch in hashMap) {
                    val v = hashMap[ch]!! - 1
                    if (v < 0) {
                        return false
                    }
                    hashMap[ch] = v
                } else {
                    return false
                }
            }
            return true
        }


    }
}