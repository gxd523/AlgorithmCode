package com.code.algorithm.sort.subject

/**
 * 剑指题：21
 * 调整数组顺序，使奇数位于偶数前面
 * 挖坑快排
 */
fun exchange(nums: IntArray): IntArray {
    if (nums.isEmpty()) return nums

    var left = 0
    var right = nums.size - 1
    val temp = nums[0]
    while (left < right) {
        while (left < right) {
            if (nums[right] % 2 == 1) {
                nums[left++] = nums[right]
                break
            } else {
                right--
            }
        }
        while (left < right) {
            if (nums[left] % 2 == 0) {
                nums[right--] = nums[left]
                break
            } else {
                left++
            }
        }
    }

    nums[left] = temp

    return nums
}