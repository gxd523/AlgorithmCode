package com.code.datastructure.array

/**
 * 剑指题50
 * 在字符串 s 中找出第一个只出现一次的字符。
 */
fun firstUniqueChar(s: String): Char {
    if (s.isEmpty()) {
        return ' '
    }

    val array = IntArray(26)
    for (i in s.indices) {
        val index = s[i].toInt() - 97
        array[index]++
    }
    for (i in s.indices) {// 两次遍历时间复杂度还是O(N)
        val index = s[i].toInt() - 97
        if (array[index] == 1) {
            return s[i]
        }
    }
    return ' '
}