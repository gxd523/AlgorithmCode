package com.code.algorithm.dynamicprogram

import kotlin.math.max

/**
 * 剑指题：47
 * m * n的矩阵，从左上角，只能向右或向左移动，到右下角经过的值之和的最大值
 */
fun maxValue(grid: Array<IntArray>): Int {
    val dp = Array(grid.size) { IntArray(grid[0].size) }

    for (i in grid.indices) {
        for (j in grid[0].indices) {
            dp[i][j] = when {
                i == 0 && j == 0 -> grid[i][j]
                i == 0 -> dp[i][j - 1] + grid[i][j]
                j == 0 -> dp[i - 1][j] + grid[i][j]
                else -> max(dp[i][j - 1], dp[i - 1][j]) + grid[i][j]
            }
        }
    }

    return dp[grid.size - 1][grid[0].size - 1]
}