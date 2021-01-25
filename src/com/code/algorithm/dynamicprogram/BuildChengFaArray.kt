package com.code.algorithm.dynamicprogram

/**
 * 剑指题：66
 * 构建乘积数组
 */
fun constructArr(a: IntArray): IntArray {
    if (a.isEmpty()) return emptyArray<Int>().toIntArray()

    val dpA = IntArray(a.size)// 构建左下角乘积数组
    dpA[0] = 1

    val dpB = IntArray(a.size)// 构建右上角乘积数组
    dpB[a.size - 1] = 1

    for (i in 1 until a.size) {
        dpA[i] = dpA[i - 1] * a[i - 1]
    }

    for (i in a.size - 2 downTo 0) {// 右上角可以优化，去掉dpB，构建右上角过程中，算出result
        dpB[i] = dpB[i + 1] * a[i + 1]
    }

    val result = IntArray(a.size)

    for (i in result.indices) {
        result[i] = dpA[i] * dpB[i]
    }

    return result
}

fun main() {
    constructArr(intArrayOf(1, 2, 3, 4, 5)).contentToString().let(::println)
}