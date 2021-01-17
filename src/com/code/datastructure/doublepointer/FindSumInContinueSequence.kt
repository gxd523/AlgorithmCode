package com.code.datastructure.doublepointer

/**
 * 剑指题57.2
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 */
fun findSumInContinueSequence(target: Int): Array<IntArray> {
    val result = mutableListOf<IntArray>()
    var p1 = 1
    var p2 = 2
    while (p1 < p2) {
        val value = (p1 + p2) * (p2 - p1 + 1) / 2// 😂，求和都忘了...
        when {
            value == target -> {
                val array = IntArray(p2 - p1 + 1)
                for (i in p1..p2) {
                    array[i - p1] = i// 这里通过i - p1获取arry的index
                }
                result += array
                p2++
            }
            value < target -> p2++
            else -> p1++
        }
    }
    return result.toTypedArray()
}

fun main() {
    val result = findSumInContinueSequence(9)
    result.forEach { it.contentToString().let(::print) }
}