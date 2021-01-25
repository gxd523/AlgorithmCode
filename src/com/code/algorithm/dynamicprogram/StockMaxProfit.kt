package com.code.algorithm.dynamicprogram

/**
 * 剑指题：63
 * 股票最大利润
 * 动态规划
 */
fun maxProfit(prices: IntArray): Int {
    var minPrice = prices[0]
    var maxProfit = 0

    for (i in 1 until prices.size) {
        maxProfit = Math.max(maxProfit, prices[i] - minPrice)
        minPrice = Math.min(minPrice, prices[i])// 0~i-1的最小值与i的值比较
    }

    return maxProfit
}