package com.code.algorithm.search

/**
 * 二分查找(数组已排序)
 */
fun halfSearchSorted(array: IntArray, target: Int, start: Int, end: Int): Int {// 前闭后开
    if (start == end) return -1

    val half = (start + end) / 2
    return when {
        array[half] > target -> halfSearchSorted(array, target, start, half)
        array[half] < target -> halfSearchSorted(array, target, half + 1, end)
        else -> half
    }
}

/**
 * 二分查找迭代版(数组已排序)
 * 统一风格：前闭后闭
 */
fun halfSearchSortedIterate(array: IntArray, target: Int): Int {// 前闭后闭
    var start = 0
    var end = array.size - 1
    while (start <= end) {
        val half = (start + end) / 2
        when {
            array[half] > target -> end = half - 1
            array[half] < target -> start = half + 1
            else -> return half
        }
    }
    return -1
}

/**
 * 二分查找(数组未排序)
 */
fun halfSearch(array: IntArray, target: Int, start: Int, end: Int): Int {// 前闭后开
    if (start == end) return -1

    val half = (start + end) / 2
    if (array[half] == target) {
        return half
    }
    val left = halfSearch(array, target, start, half)
    if (left != -1) {
        return left
    }
    val right = halfSearch(array, target, half + 1, end)
    if (right != -1) {
        return right
    }
    return -1
}

fun main() {
    intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)
        .let {
            halfSearchSortedIterate(it, 8)
        }
        .let(::println)
}