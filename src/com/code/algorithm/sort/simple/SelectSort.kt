package com.code.algorithm.sort.simple

/**
 * 选择排序
 * 遍历数组，每次从剩下的数中找出一个最小值，和当前值做交换
 * 时间复杂度：O(n²)
 * 控件复杂度：O(1)
 */
fun select(array: IntArray) {
    for (i in 0 until array.size - 1) {// 每趟确定一个数，最后一个数不用比较，所以一共比较length - 1趟
        var minIndex = i// 用一个变量记录这趟最小数的下标，减少交换次数
        for (j in i until array.size) {// 每趟从i开始，之前的数已完成排序
            if (array[minIndex] > array[j]) {
                minIndex = j
            }
        }
        if (minIndex != i) {// 每趟结束时minIndex != i说明这趟最小数不是下标i对应的数
            swap(array, minIndex, i)
        }
    }
}

fun main() {
    intArrayOf(5, 3, 2, 4, 1).apply(::select).contentToString().let(::println)
}