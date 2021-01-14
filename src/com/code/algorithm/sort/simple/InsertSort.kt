package com.code.algorithm.sort.simple

/**
 * 插入排序
 * 遍历每个元素，插入前面的有序数列
 * 插的时候，先提起这个元素，向左每找到一个比该元素大的，就右移一位，最后的空位填入该元素
 * 时间复杂度：O(n²)
 * 控件复杂度：O(1)
 */
fun insert(array: IntArray) {
    for (i in 1 until array.size) {// 每趟向前面的有序数列插入一个，所以需要插入length - 1次
        val value = array[i]// 把下标i的值提起来
        var j = i
        while (j > 0 && value < array[j - 1]) {// 向左找比value大的值，然后右移一位
            array[j] = array[j - 1]
            j--
        }
        if (j != i) {// 最后把value填进位置j
            array[j] = value
        }
    }
}

fun main() {
    intArrayOf(5, 3, 2, 4, 1).apply(::insert).contentToString().let(::println)
}