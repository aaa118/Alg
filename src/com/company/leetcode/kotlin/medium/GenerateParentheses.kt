package com.company.leetcode.kotlin.medium

import java.util.Stack


class GenerateParentheses {
    companion object {
        private var res = mutableListOf<String>()

        @JvmStatic
        fun main(args: Array<String>) {
            println(generateParenthesis(3))
        }

        private fun generateParenthesis(n: Int): List<String> {
            val stack = Stack<Char>()
//            backtrack(0, 0, stack, res, n)
            rec("", n, n)
            return res
        }
        private fun backtrack(openN: Int, closedN: Int, stack: Stack<Char>, res: MutableList<String>, n: Int,) {
            if (openN == closedN && openN == n) {
                res.add(stack.joinToString(""))
                return
            }

            if (openN < n) {
                stack.add('(')
                backtrack(openN + 1, closedN, stack, res, n)
                stack.pop()
            }
            if (closedN < openN) {
                stack.add(')')
                backtrack(openN, closedN + 1, stack, res, n)
                stack.pop()
            }
        }
        fun rec(s: String, l: Int, r: Int) {
            if (l > 0) {
                rec("$s(", l - 1, r)
            }
            if(r > 0 && r > l) {
                rec("$s)", l, r - 1)
            } else if (r == 0 && l == 0) {
                res.add(s)
            }
        }
    }
}