package com.code.datastructure.array

/**
 * 剑指题50
 * 在字符串 s 中找出第一个只出现一次的字符。
 */
fun first(s: String): Char {
    if (s.isEmpty()) {
        return ' '
    }

    // 数组长度为字符的种类个数，ASCII一共128种
    val onceArray = BooleanArray(26) { false }
    // 用两个固定长度的数组，空间复杂度为O(1)，使用Boolean作为元素节约空间
    val twiceArray = BooleanArray(26) { false }

    for (c in s) {
        val index = c.toInt() - 97
        if (!onceArray[index]) {
            onceArray[index] = true
        } else if (!twiceArray[index]) {
            twiceArray[index] = true
        }
    }

    for (c in s) {// 注意：循环2次字符串的时间复杂度还是O(n)，不是O(n²)
        val index = c.toInt() - 97
        if (onceArray[index] && !twiceArray[index]) {
            return c
        }
    }
    return ' '
}

fun main() {
    first("leetcode").let(::println)
}