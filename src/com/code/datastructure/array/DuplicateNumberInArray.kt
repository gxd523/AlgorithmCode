package com.code.datastructure.array

/**
 * 剑指题3
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 */
fun duplicate(array: IntArray): Int {
    for (i in array.indices) {
        while (array[i] != i) {// 每次检查下标i是否等于下标对应的值，相等则下标i加1
            val value = array[i]

            if (array[value] == value) {// 值作为下标所对应的值，如果和作为下标的的值相等，则找到了重复数字
                return value
            }
            // 否则交换，下标i赋上value下标之前的值
            val temp = array[value]
            array[value] = value
            array[i] = temp
        }
    }
    return -1
}

fun main() {
    duplicate(
//        intArrayOf(6, 3, 2, 0, 2, 5, 0)
        intArrayOf(2, 3, 1, 0, 2, 5, 3)
    ).let(::println)
}