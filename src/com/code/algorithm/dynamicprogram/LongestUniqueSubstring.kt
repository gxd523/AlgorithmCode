package com.code.algorithm.dynamicprogram

/**
 * 剑指题：48
 * 最长不含重复字符的子字符串
 */
fun lengthOfLongestSubstring(s: String): Int {
    var start = 0
    var max = 0
    for (i in s.indices) {
        for (j in start until i) {
            if (s[i] == s[j]) {
                start = j + 1
                break
            }
        }

        if (i - start + 1 > max) max = i - start + 1
    }

    return max
}