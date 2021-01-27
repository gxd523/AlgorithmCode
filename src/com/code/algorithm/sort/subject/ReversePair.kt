package com.code.algorithm.sort.subject

/**
 * 剑指题：51
 * 归并排序
 */
fun reversePairs(nums: IntArray): Int {
    return mergeSort(nums, 0, nums.size - 1)
}

fun mergeSort(array: IntArray, left: Int, right: Int): Int {
    if (left >= right) return 0

    val mid = (left + right) / 2
    val leftReverseCount = mergeSort(array, left, mid)// 返回左区间内部的逆序对个数
    val rightReverseCount = mergeSort(array, mid + 1, right)// 返回右区间内部的逆序对个数

    var l = left
    var r = mid + 1

    val tempArr = IntArray(right - left + 1)
    var index = 0

    var reverseCount = 0// 两个区间各选一个数产生的逆序对个数
    while (l <= mid || r <= right) {
        when {
            l > mid -> {
                tempArr[index++] = array[r++]
            }
            r > right -> {
                tempArr[index++] = array[l++]
            }
            array[l] <= array[r] -> {
                tempArr[index++] = array[l++]
            }
            else -> {
                tempArr[index++] = array[r++]
                reverseCount = mid - l + 1// 等于把归并排序写一遍，在加上这句，左区间剩余的数，比右区间当前指向的数大，所以累加左区间的元素个数
            }
        }
    }
    return leftReverseCount + rightReverseCount + reverseCount
}