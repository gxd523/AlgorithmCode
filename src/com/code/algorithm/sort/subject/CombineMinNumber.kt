package com.code.algorithm.sort.subject

/**
 * 剑指题：45
 * 把数组排成最小的数
 */
fun minNumber(nums: IntArray): String {
    quickSort(nums, 0, nums.size - 1)

    val builder = StringBuilder()
    for (n in nums) {
        builder.append(n)
    }
    return builder.toString()
}

fun quickSort(nums: IntArray, left: Int, right: Int) {
    if (left >= right) return

    var l = left
    var r = right
    val pivot = nums[left]
    while (l < r) {
        while (l < r) {
            if ("${nums[r]}$pivot" < "$pivot${nums[r]}") {
                nums[l++] = nums[r]
                break
            } else {
                r--
            }
        }
        while (l < r) {
            if ("${nums[l]}$pivot" > "$pivot${nums[l]}") {
                nums[r--] = nums[l]
                break
            } else {
                l++
            }
        }
    }

    nums[l] = pivot

    quickSort(nums, left, l - 1)
    quickSort(nums, l + 1, right)
}