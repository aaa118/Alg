package com.company.leetcode.kotlin.medium.backtrack

import java.util.*


class CombinationSum {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var array = intArrayOf(2,3,6,7)
            var array2 = intArrayOf(2,5,2,1,2)
            println(combinationSum2(array2, 5))
            println('4' - '0')

        }
        fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
            var res = mutableListOf<List<Int>>()
            var curr = mutableListOf<Int>()
            var q = LinkedList<Int>()
            q.peekFirst()

            fun dfs(i: Int, cur: MutableList<Int>, total: Int) {
                if (total == target) {
                    println(total)
                    var _cur = cur
                    res.add(_cur.toList())
                    return
                }
                if (i >= candidates.size || total > target) return
                cur.add(candidates[i])
                dfs(i, cur, total + candidates[i])
                cur.remove(candidates[i])
                dfs(i + 1, cur, total)
            }

            dfs(0, curr, 0)

            return res
        }

        fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
            val res = mutableListOf<List<Int>>()
            candidates.sort()
            val temp = mutableListOf<Int>()
            fun backtrack(total: Int, _i: Int, temp: MutableList<Int>) {
                if (total > target || _i >= candidates.size) return
                if (total == target) {
                    res.add(temp.toList())
                    return
                }
                var i = _i
                temp.add(candidates[i])
                backtrack(total + candidates[i], i + 1, temp)
                temp.removeAt(temp.lastIndex)
                while ((i + 1) < candidates.size && candidates[i] == candidates[i + 1]) i++
                backtrack(total, i + 1, temp)
            }

            backtrack(0, 0, temp)
            return res
        }
    }
}