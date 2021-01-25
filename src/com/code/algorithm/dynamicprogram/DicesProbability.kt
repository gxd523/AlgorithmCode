package com.code.algorithm.dynamicprogram

import kotlin.math.pow

/**
 * 剑指题：60
 * n个色子的所有点数的概率
 */
fun dicesProbability(n: Int): DoubleArray {
    val dp = Array(n + 1) { IntArray(6 * n + 1) }
    for (i in 1..6) {
        dp[1][i] = 1
    }

    for (i in 2..n) {
        for (j in i..6 * i) {
            for (k in 1..6) {
                if (j - k > 0) {
                    dp[i][j] += dp[i - 1][j - k]
                }
            }
        }
    }

    val result = DoubleArray(5 * n + 1)
    val count = 6.0.pow(n)
    for (i in n..6 * n) {
        result[i - n] = dp[n][i] / count
    }

    dp.forEach {
        println(it.contentToString())
    }

    return result
}

fun main() {
    dicesProbability(2).contentToString().let(::println)
}