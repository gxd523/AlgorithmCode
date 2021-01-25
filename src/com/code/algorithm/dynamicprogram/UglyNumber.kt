package com.code.algorithm.dynamicprogram

import kotlin.math.min

/**
 * 剑指题：49
 * 丑数：我们把只包含质因子 2、3 和 5 的数称作丑数
 */
fun uglyNumber(n: Int): Int {
    var a = 0// a、b、c三个指针不断往右移动
    var b = 0
    var c = 0
    val dp = IntArray(n)// 丑数数组
    dp[0] = 1// 最小的丑数是1

    for (i in 1 until n) {
        val valueA = dp[a] * 2// 指针a对应的丑数分别乘以2、3、5，生成新的丑数
        val valueB = dp[b] * 3
        val valueC = dp[c] * 5

        dp[i] = min(valueA, min(valueB, valueC))// 从3个丑数中选一个最小的

        if (dp[i] == valueA) {
            a++
        }
        if (dp[i] == valueB) {// 注意这里不用else if连起来是因为2*3、3*2是一个丑数，要跳过
            b++
        }
        if (dp[i] == valueC) {
            c++
        }
    }

    return dp[n - 1]
}