package com.code.algorithm.search

/**
 * 剑指题：53.2
 * 数字0-n在长度为n的数组中，且不重复，找出缺失的数字
 */
fun missingNumber(nums: IntArray): Int {
    var left = 0
    var right = nums.size - 1
    while (left <= right) {
        val mid = (left + right) / 2
        if (nums[mid] != mid) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return left
}