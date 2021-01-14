package com.code.algorithm.sort.simple

/**
 * 希尔排序
 * 插入排序的步长升级版
 * 时间复杂度：O(n²)
 * 控件复杂度：O(1)
 */
fun shell(array: IntArray) {
    var step = array.size / 2
    while (step > 0) {
        for (i in step until array.size) {// 每趟向前面的有序数列插入一个，所以需要插入length - 1次
            val value = array[i]// 把下标i的值提起来
            var j = i
            while (j > 0 && value < array[j - step]) {// 向左找比value大的值，然后右移一位
                array[j] = array[j - step]
                j -= step
            }
            if (j != i) {// 最后把value填进位置j
                array[j] = value
            }
        }
        step /= 2
    }
}

fun main() {
    intArrayOf(5, 3, 2, 4, 1).apply(::shell).contentToString().let(::println)
}