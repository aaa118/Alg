package com.company.general.java

import kotlin.Throws
import java.io.FileNotFoundException
import kotlin.jvm.JvmStatic
import com.company.general.java.CashRegister
import java.io.File
import java.lang.StringBuilder
import java.util.*

object CashRegister {
    @Throws(FileNotFoundException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val file = File(args[0])
        val fileInput = Scanner(file)
        while (fileInput.hasNextLine()) {
            printCashChange(fileInput.nextLine())
        }
    }

    private fun printCashChange(line: String) {
        val pp = line.split(";".toRegex()).toTypedArray()[0].toFloat()
        val ch = line.split(";".toRegex()).toTypedArray()[1].toFloat()
        println(getCashChange(pp, ch))
    }

    private fun getCashChange(price: Float, cash: Float): String {
        if (cash < price) {
            return "ERROR"
        }
        if (cash == price) {
            return "ZERO"
        }
        var cashBack = cash - price
        val change = StringBuilder()
        while (cashBack > 0.01f) {
            cashBack -= if (cashBack >= 100.0f) {
                change.append("ONE HUNDRED")
                100.0f
            } else if (cashBack >= 50.0f) {
                change.append("FIFTY")
                50.0f
            } else if (cashBack >= 20.0f) {
                change.append("TWENTY")
                20.0f
            } else if (cashBack >= 10.0f) {
                change.append("TEN")
                10.0f
            } else if (cashBack >= 5.0f) {
                change.append("FIVE")
                5.0f
            } else if (cashBack >= 2.0f) {
                change.append("TWO")
                2.0f
            } else if (cashBack >= 1.0f) {
                change.append("ONE")
                1.0f
            } else if (cashBack >= 0.5f) {
                change.append("HALF DOLLAR")
                0.5f
            } else if (cashBack >= 0.25f) {
                change.append("QUARTER")
                0.25f
            } else if (cashBack >= 0.1f) {
                change.append("DIME")
                0.1f
            } else if (cashBack >= 0.05f) {
                change.append("NICKEL")
                0.05f
            } else {
                change.append("PENNY")
                0.01f
            }
            change.append(",")
        }
        change.setLength(change.length - 1)
        return change.toString()
    }
}