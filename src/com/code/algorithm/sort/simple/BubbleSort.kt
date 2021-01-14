package com.code.algorithm.sort.simple

/**
 * 冒泡排序
 * 时间复杂度：O(n²)
 * 控件复杂度：O(1)
 */
fun bubble(array: IntArray) {
    for (i in 0 until array.size - 1) {// 一趟确定一个数，最后剩下的一个不用比，所以比较n-1趟
        for (j in 0 until array.size - 1 - i) {// 每趟比较到倒数第二个元素再减趟数(趟数从0开始)
            if (array[j] > array[j + 1]) {
                swap(array, j, j + 1)
            }
        }
    }
}

fun swap(array: IntArray, m: Int, n: Int) {
    val temp = array[n]
    array[n] = array[m]
    array[m] = temp
}

fun main() {
    intArrayOf(5, 3, 2, 4, 1).apply(::bubble).contentToString().let(::println)
}