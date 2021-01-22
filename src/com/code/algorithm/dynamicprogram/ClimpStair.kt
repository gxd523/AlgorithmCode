package com.code.algorithm.dynamicprogram

/**
 * 爬楼梯
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 动态规划
 * 规律：第n阶爬楼梯的种类数为：n - 2阶爬楼梯的种类数 + n - 1阶爬楼梯的种类数，1、2、3、5、8、13
 */
fun climbStair(n: Int): Int {
    if (n == 1) return 1
    if (n == 2) return 2

    var first = 1
    var second = 2
    for (i in 3..n) {
        val sum = first + second
        // 为下一次做准备，下一次的first是当前的second，下一次的second是当前的sum
        first = second
        second = sum
    }
    return second
}