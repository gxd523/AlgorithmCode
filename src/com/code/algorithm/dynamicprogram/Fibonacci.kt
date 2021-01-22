package com.code.algorithm.dynamicprogram

/**
 * 剑指题：10.1
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项
 */
fun fibonacci(n: Int): Int {
    if (n == 0) return 0
    if (n == 1) return 1

    var first = 0
    var second = 1
    for (i in 2..n) {
        val sum = (first + second) % 1000000007
        first = second
        second = sum
    }
    return second
}