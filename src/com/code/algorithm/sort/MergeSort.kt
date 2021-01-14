package com.code.algorithm.sort

/**
 * 归并排序
 */
fun merge(array: IntArray) {
    splitArray(array, 0, array.size)
}

fun splitArray(array: IntArray, l: Int, r: Int) {// 前闭后开，否则不好处理
    if (l + 1 == r) {
        return
    }

    val mid = (l + r) / 2
    splitArray(array, l, mid)
    splitArray(array, mid, r)

    mergeArray(array, l, mid, r)
}

fun mergeArray(array: IntArray, l: Int, m: Int, r: Int) {
    val temp = IntArray(r - l)
    var left = l
    var right = m
    var n = 0
    while (left < m || right < r) {
        when {
            left == m -> temp[n++] = array[right++]
            right == r -> temp[n++] = array[left++]
            array[left] > array[right] -> temp[n++] = array[right++]
            else -> temp[n++] = array[left++]
        }
    }

    System.arraycopy(temp, 0, array, l, temp.size)
}

fun main() {
    intArrayOf(8, 3, 2, 7, 5, 6, 4, 1).apply(::merge).contentToString().let(::println)
}
