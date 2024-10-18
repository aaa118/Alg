package com.company.leetcode.kotlin.arrayandstrings.medium

class ValidIpAddress {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }
    }

    fun validIPAddress(queryIP: String): String {
        val splitByDecimal = queryIP.split('.')
        return if (splitByDecimal.size == 4) {
            validateIPv4(splitByDecimal).value
        } else {
            validateIPv6(queryIP).value
        }
    }

    private fun validateIPv4(splits: List<String>): IPAddress {
        for (split in splits) {
            val intValue = split.toIntOrNull() ?: return IPAddress.NEITHER
            if (intValue == 0 && split.length > 1) {
                return IPAddress.NEITHER
            }
            if (split.startsWith('0') && intValue != 0) {
                return IPAddress.NEITHER
            }
            if (intValue < 0) {
                return IPAddress.NEITHER
            }
            if (intValue > 255) {
                return IPAddress.NEITHER
            }
        }
        return IPAddress.V4
    }

    private fun validateIPv6(queryIP: String): IPAddress {
        val splits = queryIP.split(':')
        if (splits.size != 8) return IPAddress.NEITHER

        for (split in splits) {
            if (split.length > 4) return IPAddress.NEITHER
            val hex = split.toInt(16) ?: return IPAddress.NEITHER
            if (hex < 0) return IPAddress.NEITHER
        }
        return IPAddress.v6
    }

    enum class IPAddress(val value: String) {
        V4("IPv4"),
        v6("IPv6"),
        NEITHER("Neither")
    }
}