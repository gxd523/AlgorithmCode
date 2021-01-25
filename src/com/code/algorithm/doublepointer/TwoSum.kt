package com.code.algorithm.doublepointer

/**
 * 剑指题57.1
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 */
fun twoSum(array: IntArray, target: Int): IntArray {
    var p1 = 0
    var p2 = array.size - 1
    while (p1 != p2) {// 前后双指针向中间靠拢
        when {
            array[p1] + array[p2] == target -> return intArrayOf(array[p1], array[p2])
            array[p1] + array[p2] < target -> p1++
            else -> p2--
        }
    }
    return intArrayOf()
}

fun main() {
    twoSum(intArrayOf(1, 2, 4, 5, 7, 8), 12).contentToString().let(::println)
}