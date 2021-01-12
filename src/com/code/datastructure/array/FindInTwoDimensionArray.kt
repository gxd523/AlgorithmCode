package com.code.datastructure.array

/**
 * 剑指题4
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。
 * 给定一个数，判断这个数是否在该二维数组中。
 */
fun find(target: Int, array: Array<IntArray>): Boolean {
    var i = 0
    var j = array[0].size - 1
    while (i < array.size && j > 0) {// 从右往左，从上往下，逐步缩小二维数组的范围
        when {
            array[i][j] > target -> {// 如果当前值>target，因为当前值所在列下面的数字更大，所以排除当前值所在列
                j--
            }
            array[i][j] < target -> {// 如果当前值<target，因为当前值左边的数更小，所以排除当前值所在行
                i++
            }
            else -> return true
        }
    }
    return false
}

fun main() {
    val arrayOf: Array<IntArray> = arrayOf(
        intArrayOf(1, 4, 7, 11, 15),
        intArrayOf(2, 5, 8, 12, 19),
        intArrayOf(10, 13, 14, 17, 24),
        intArrayOf(18, 21, 23, 26, 30),
    )

    find(24, arrayOf).let(::println)
}