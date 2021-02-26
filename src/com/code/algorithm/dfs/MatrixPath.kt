package com.code.algorithm.dfs

/**
 * 剑指题：12
 * 判断矩阵中的是否存在该路径
 *
 * 直接在原矩阵上标记已走过的路径，就不用集合保存路径了
 * 把各种条件判断写到递归函数的开始
 */
fun exist(board: Array<CharArray>, word: String): Boolean {
    val array = word.toCharArray()
    for (i in board.indices) {
        for (j in board[0].indices) {
            if (matrixDfs(board, array, i, j, 0)) return true
        }
    }
    return false
}

fun matrixDfs(board: Array<CharArray>, array: CharArray, i: Int, j: Int, k: Int): Boolean {
    if (i < 0 || i >= board.size || j < 0 || j >= board[0].size) return false// 路径不在矩阵范围内
    if (array[k] != board[i][j]) return false

    if (k + 1 == array.size) return true

    board[i][j] = '\u0000'// 走过的元素标为空

    val result = matrixDfs(board, array, i - 1, j, k + 1) ||
            matrixDfs(board, array, i + 1, j, k + 1) ||
            matrixDfs(board, array, i, j - 1, k + 1) ||
            matrixDfs(board, array, i, j + 1, k + 1)

    board[i][j] = array[k]// 回退时还原之前表为空的元素
    return result
}

fun main() {
    exist(arrayOf(
        charArrayOf('A', 'B', 'C', 'E'),
        charArrayOf('S', 'F', 'C', 'S'),
        charArrayOf('A', 'D', 'E', 'E'),
    ), "ABCCED").let(::println)
}
