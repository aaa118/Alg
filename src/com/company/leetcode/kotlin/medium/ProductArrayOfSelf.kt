package com.company.leetcode.kotlin.medium

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 *
 * Solution Notes: Create result array, 1st with all the product of all the indices before it. Assume 1 for the first
 * index. Then update the array by multiplying it with the product of all the indices after it.
 */
class ProductArrayOfSelf {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            val nums = intArrayOf(1, 2, 3, 4)
            println(productExceptSelf(nums).asList())

        }

        private fun productExceptSelf(nums: IntArray): IntArray {
            val res = IntArray(nums.size)
            var currentProductPre = 1
            for (index in nums.indices) {
                res[index] = currentProductPre
                currentProductPre *= nums[index]
            }
            var currentProductPost = 1
            for (i in nums.size - 1 downTo 0 ) {
                res[i] = res[i] * currentProductPost
                currentProductPost *= nums[i]
            }
            return res
        }
    }
}