package com.code.datastructure.doublepointer

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