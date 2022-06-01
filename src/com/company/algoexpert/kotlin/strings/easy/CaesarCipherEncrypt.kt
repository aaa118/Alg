package com.company.algoexpert.kotlin.strings.easy

class CaesarCipherEncrypt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        fun caesarCipherEncryptor(string: String, key: Int): String {
            // Write your code here.

            val sb = StringBuilder()

            for (cha in string) {
                val ascii = cha.toInt()
                val fCode = shift(ascii, key)
                val fChar = fCode.toChar()
                sb.append(fChar)
            }
            return sb.toString()
        }

        private fun shift(ascii: Int, key : Int) : Int {
            var k = key
            if (key > 26) {
                k = key % 26
            }
            val s = ascii + k
            return if (s < 123) {
                s
            } else {
                96 + s % 122
            }
        }

    }
}