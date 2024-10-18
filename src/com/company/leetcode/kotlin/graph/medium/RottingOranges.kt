package com.company.leetcode.kotlin.graph.medium

class RottingOranges {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val grid = arrayOf(intArrayOf(2, 1, 1), intArrayOf(1, 1, 0), intArrayOf(0, 1, 1))
            println(orangesRotting(grid))

        }

        private fun orangesRotting(grid: Array<IntArray>): Int {
            val rows = grid.size
            val cols = grid[0].size
            var fresh = 0
            var min = 0
            val q = ArrayDeque<Pair<Int, Int>>()
            val hashMap = mutableSetOf<Pair<Int, Int>>()

            for (i in 0 until rows) {
                for (j in 0 until cols) {
                    if (grid[i][j] == 1) {
                        fresh++
                    } else if (grid[i][j] == 2) {
                        q.add(Pair(i, j))
                        hashMap.add(Pair(i, j))
                    }
                }
            }

            while (q.isNotEmpty() && fresh > 0) {
                val size = q.size
                for (i in 0..size - 1) {
                    val cord = q.removeFirst()
                    fresh = bfs(cord.first + 1, cord.second, grid, q, fresh, hashMap)
                    fresh = bfs(cord.first - 1, cord.second, grid, q, fresh, hashMap)
                    fresh = bfs(cord.first, cord.second + 1, grid, q, fresh, hashMap)
                    fresh = bfs(cord.first, cord.second - 1, grid, q, fresh, hashMap)
                }
                min++
            }

            return if (fresh > 0) return -1 else min
        }

        private fun bfs(
            r: Int,
            c: Int,
            grid: Array<IntArray>,
            q: ArrayDeque<Pair<Int, Int>>,
            fresh: Int,
            hashMap: MutableSet<Pair<Int, Int>>
        ): Int {
            if (r < 0 || r >= grid.size || c < 0 || c >= grid[0].size || grid[r][c] == 0 || grid[r][c] == 2 || hashMap.contains(Pair(r, c))) {
                return fresh
            }
            q.add(Pair(r, c))
            hashMap.add(Pair(r, c))
            var _fresh = fresh
            _fresh--
            return _fresh
        }

    }
}