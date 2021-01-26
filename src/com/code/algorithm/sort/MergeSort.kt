package com.code.algorithm.sort

/**
 * 归并排序
 */
fun merge(array: IntArray) {
    splitArray(array, 0, array.size)
}

fun splitArray(array: IntArray, l: Int, r: Int) {// 前闭后开
    if (l + 1 == r) {// 前闭后闭则为l==r，也就是只剩一个元素
        return
    }

    val mid = (l + r) / 2
    splitArray(array, l, mid)// 注意：前闭后闭时不要写成mid - 1，否则l=1，r=2时，mid - 1 = 0，l<mid，就不好处理了
    splitArray(array, mid, r)// 前闭后闭则为mid+1

    mergeArray(array, l, mid, r)// 前闭后闭则为mid+1
}

fun mergeArray(array: IntArray, l: Int, m: Int, r: Int) {
    val temp = IntArray(r - l)// 前闭后闭则为r-l+1
    var left = l
    var right = m// 前闭后闭则为m+1
    var n = 0
    while (left < m || right < r) {// 前闭后闭则为left <= m || right <= r
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
