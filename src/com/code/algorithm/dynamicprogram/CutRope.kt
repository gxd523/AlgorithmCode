package com.code.algorithm.dynamicprogram

import kotlin.math.max

/**
 * 剑指题：14
 * 长度为n的绳子，分为k段，每段长度相乘的结果最大值
 * 动态规划解法
 * 绳子(长i)先分为2部分，j与i - j，那么乘积就是i * (i - j)
 * 如果i - j，继续拆分成2个及以上的乘数，那么它的结果已经在前面算过了，即dp[i - j]
 * 从i - j与dp[i - j]中选出大值，并遍历j直到i - 1，选出最大的就是dp[i]
 */
fun cuttingRope(n: Int): Int {
//    if (n == 2) return 1
//    if (n == 3) return 2

    val dp = IntArray(n + 1)
    for (i in 2..n) {
        for (j in 1 until n) {// j的范围可以优化到2 until n - 1，因为1作为乘数结果不变
            dp[i] = max(dp[i], j * max(i - j, dp[i - j]))
        }
    }
    return dp[n]
}

/**
 * 剑指题：14
 * 长度为n的绳子，分为k段，每段长度相乘的结果最大值
 * 贪心算法
 * 拆分成1和n - 1，肯定不行
 * 拆分成5和n - 5，也不行，因为把5拆分成2和3的乘积为6>5
 * 拆分成6，7，8...也是这样
 * 拆分成2、3比较合理
 * 但2、3之间优先选3，因为6拆分成3*3比拆分成2*2*2更大
 * 得出局部最后解：优先分成3米长，其次分成2米长，再相乘
 */
fun cuttingRope1(n: Int): Int {
    if (n == 2) return 1
    if (n == 3) return 2

    val threeCount = n / 3

    return when {
        n % 3 == 1 -> 3.pow(threeCount - 1) * 4
        n % 3 == 2 -> 3.pow(threeCount) * 2
        else -> 3.pow(threeCount)
    }
}

private fun Int.pow(b: Int): Int {
    return Math.pow(this.toDouble(), b.toDouble()).toInt()
}