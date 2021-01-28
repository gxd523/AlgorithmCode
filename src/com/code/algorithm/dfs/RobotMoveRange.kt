package com.code.algorithm.dfs

/**
 * 剑指题：13
 * 机器人运动范围
 * 机器人从0,0点，每次只能上下左右走一步
 * 横纵坐标的每一位数字之和要<=k
 * 求机器人的活动范围
 */
fun movingCount(m: Int, n: Int, k: Int): Int {
    val list = emptyList<String>().toMutableList()
    robotDfs(list, m, n, k, 0, 0)
    return list.size
}

fun robotDfs(list: MutableList<String>, m: Int, n: Int, k: Int, i: Int, j: Int) {
    if (i >= m || j >= n) return// 由于不用向上、向左走，所以i、j不会<0
    if (list.contains("$i,$j")) return// 如果走过了位置就返回
    if (sum(i) + sum(j) > k) return// 不符合条件的位置也返回，因为只能一格一格走

    list += "$i,$j"

    robotDfs(list, m, n, k, i + 1, j)// 只用向下、向右走就可以了，不用向上、向左走
    robotDfs(list, m, n, k, i, j + 1)
}

fun sum(i: Int): Int {// 计算每一位数字之和
    var n = i
    var sum = 0
    while (n > 0) {
        sum += n % 10
        n /= 10
    }
    return sum
}