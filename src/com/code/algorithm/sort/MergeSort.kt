package com.code.algorithm.sort

/**
 * 归并排序
 * 分治思想
 */
fun merge(array: IntArray) {
    mergeSort(array, 0, array.size - 1)
}

fun mergeSort(array: IntArray, left: Int, right: Int) {// 前闭后闭
    if (left >= right) return

    val mid = (left + right) / 2
    mergeSort(array, left, mid)
    mergeSort(array, mid + 1, right)

    var l = left
    var r = mid + 1

    val temp = IntArray(right - left + 1)
    var index = 0
    while (l <= mid || r <= right) {
        when {
            l > mid -> temp[index++] = array[r++]
            r > right -> temp[index++] = array[l++]
            array[l] < array[r] -> temp[index++] = array[l++]
            else -> temp[index++] = array[r++]
        }
    }
    System.arraycopy(temp, 0, array, left, temp.size)
}

fun main() {
    intArrayOf(8, 3, 2, 7, 5, 6, 4, 1).apply(::merge).contentToString().let(::println)
}
