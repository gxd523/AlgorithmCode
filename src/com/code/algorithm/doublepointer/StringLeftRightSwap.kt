package com.code.algorithm.doublepointer

/**
 * 剑指题：58.2
 * 左旋字符串：比如，输入字符串"abcdefg"和数字2，左旋成"cdefgab"
 * 左右子串分别翻转，整串再翻转，同[reverseWords]
 */
fun leftRightSwap(s: String, n: Int): String {
    val array = s.toCharArray()

    reverse1(array, 0, n - 1)
    reverse1(array, n, array.size - 1)
    reverse1(array, 0, array.size - 1)
    return String(array)
}

fun reverse1(array: CharArray, m: Int, n: Int) {
    var x = m
    var y = n
    while (x < y) {
        swap(array, x++, y--)
    }
}

fun swap(array: CharArray, i: Int, j: Int) {
    val temp = array[j]
    array[j] = array[i]
    array[i] = temp
}

fun main() {
    leftRightSwap("abcdefg", 2).let(::println)
}