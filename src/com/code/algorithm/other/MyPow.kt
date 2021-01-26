package com.code.algorithm.other

/**
 * 剑指题：16
 * 实现x^n
 */
fun myPow(x: Double, n: Int): Double {
    var a = x
    var b = n.toLong()// 因为int的负数部分比整数部分多1，所以int的最小负数无法转换为最大整数
    if (b < 0) {// 负次方数=底数分之一的正次方数
        a = 1 / a
        b = -b
    }
    var result = 1.0
    while (b > 0) {// 次方数拆解成2进制表示，遍历每一位，如果为1，就乘以相应的次方结果
        if (b.and(1).toInt() == 1) result *= a
        a *= a// n^1 == n、n^2
        b = b.shr(1)
    }
    return result
}
