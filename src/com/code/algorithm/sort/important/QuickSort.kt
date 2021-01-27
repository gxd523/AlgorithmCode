package com.code.algorithm.sort.important

import com.code.algorithm.sort.simple.swap
import kotlin.random.Random

/**
 * 快速排序
 * 采用分治思想
 * 时间复杂度：O(n²)
 * 控件复杂度：O(1)
 */
fun quick(array: IntArray) {
    partition(array, 0, array.size - 1)
}

/**
 * 1、先选第一个值为pivot
 * 2、再从另一端倒序找到小于pivot的值，放到左坑
 * 3、再从左边正序找到大于pivot的值，放到右坑
 * 4、如此往复，直到左右指针相遇，相遇位置填入pivot
 * 5、之后pivot左右的子数组，分别重复上面的步骤，直到子数组长度为1
 */
fun partition(array: IntArray, l: Int, r: Int) {
    if (l >= r) return

    optimizePivot(array, l, r)
    var left = l
    var right = r
    val pivot = array[left]// 先将pivot保存，空出第一个坑位
    while (left < right) {
        while (left < right) {// 从右往左，找小于pivot的值，放入左边的坑位
            if (array[right] < pivot) {
                array[left++] = array[right]
                break
            } else {
                right--
            }
        }
        while (left < right) {// 从左往右，找大于pivot的值，放到右边的坑位
            if (array[left] > pivot) {
                array[right--] = array[left]
                break
            } else {
                left++
            }
        }
    }
    array[left] = pivot

    partition(array, l, left - 1)
    partition(array, left + 1, r)
}

/**
 * 1、先选第一个值为pivot
 * 2、左指针找到大于pivot的值停止
 * 3、右指针找到小于pivot的值停止
 * 4、左右互换，注意前提是左指针小于右指针
 * 5、最后pivot和右指针位置互换
 */
fun partitionSwap(array: IntArray, l: Int, r: Int): Int {
    optimizePivot(array, l, r)
    var left = l + 1
    var right = r
    val pivot = array[l]
    while (left <= right) {
        while (left <= right && array[left] < pivot) {
            left++
        }
        while (left <= right && array[right] > pivot) {
            right--
        }
        if (left < right) {
            swap(array, left++, right--)
        }
    }
    swap(array, l, right)
    return right
}

fun optimizePivot(array: IntArray, l: Int, r: Int) {
    val pivotIndex = Random.nextInt(l, r)
    swap(array, l, pivotIndex)
}

fun main() {
    intArrayOf(0, 0, 1, 2, 4, 2, 2, 3, 1, 4).apply(::quick).contentToString().let(::println)
}