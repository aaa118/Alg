package com.company.leetcode.kotlin.graph.medium

import kotlin.math.max
import kotlin.math.min

/**
 * https://leetcode.com/problems/graph-valid-tree/description/
 * You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of edges
 * where edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.
 *
 * Return true if the edges of the given graph make up a valid tree, and false otherwise.
 */
class GraphValidTree {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val arrayOfIntArray1 = arrayOf(
                intArrayOf(0, 1),
                intArrayOf(0, 2),
                intArrayOf(0, 3),
                intArrayOf(1, 4)
            )
            // [0,1],[1,2],[2,3],[1,3],[1,4]
            val arrayOfIntArray2 = arrayOf(
                intArrayOf(0, 1),
                intArrayOf(2, 2),
                intArrayOf(2, 3),
                intArrayOf(1, 3),
                intArrayOf(1, 4),
            )
            println(validTree(5, arrayOfIntArray1))
            println(validTree(5, arrayOfIntArray2))
        }

        fun validTree(n: Int, edges: Array<IntArray>): Boolean {
            val visited = mutableSetOf<Int>()
            val adj = Array<MutableList<Int>>(n) {  mutableListOf() }

            for (edge in edges) {
                adj[edge[0]].add(edge[1])
                adj[edge[1]].add(edge[0])
            }

            fun dfs(node: Int, parent: Int): Boolean {
                if (visited.contains(node)) {
                    return false
                }
                visited.add(node)

                for (nei in adj[node]) {
                    if (nei == parent) continue
                    // return false as loop detected
                    if (!dfs(nei, node)) return false
                }
                return true
            }

            return dfs(0, - 1) && visited.size == n
        }

    }
}