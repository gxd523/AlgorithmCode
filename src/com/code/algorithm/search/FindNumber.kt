package com.code.algorithm.search

/**
 * 剑指题：53.1
 * 统计一个数字在排序数组中出现的次数
 */
fun search(nums: IntArray, target: Int): Int {
    if (nums.isEmpty()) return 0

    var left = 0
    var right = nums.size - 1
    while (left <= right) {// 先找出左边界，即target左边的的下标
        val mid = (left + right) / 2
        if (nums[mid] >= target) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }

    if (right + 1 < nums.size && nums[right + 1] != target) {// 如果target没找到就不用找右边界
        return 0
    }

    val start = right
    left = right
    right = nums.size - 1
    while (left <= right) {// 找到右边界，即target右边的下标
        val mid = (left + right) / 2
        if (nums[mid] <= target) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    return left - start - 1// 右边界-左边界-1就是target的个数
}