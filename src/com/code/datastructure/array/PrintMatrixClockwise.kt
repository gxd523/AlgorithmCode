package com.code.datastructure.array

/**
 * 剑指题29
 * 按顺时针的方向，从外到里打印矩阵的值。
 */
fun printMatrix(matrix: Array<IntArray>): IntArray {
    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return IntArray(0)
    }
    val rowSize = matrix.size
    val colSize = matrix[0].size

    val result = IntArray(rowSize * colSize)
    printRowOrCol(matrix, result, 0, 0, rowSize - 1, 0, colSize - 1, 4)
    return result
}

fun printRowOrCol(
    array: Array<IntArray>,
    result: IntArray,
    resultIndex: Int,
    startRow: Int,
    endRow: Int,
    startCol: Int,
    endCol: Int,
    direct: Int
) {
    var tempResultIndex = resultIndex
    when (direct) {
        1 -> {// 上
            for (i in endRow downTo startRow) {
                result[tempResultIndex++] = array[i][startCol]
            }

            if (startCol + 1 <= endCol) {
                printRowOrCol(array, result, tempResultIndex, startRow, endRow, startCol + 1, endCol, 4)
            }
        }
        2 -> {// 下
            for (i in startRow..endRow) {
                result[tempResultIndex++] = array[i][endCol]
            }

            if (endCol - 1 >= startCol) {
                printRowOrCol(array, result, tempResultIndex, startRow, endRow, startCol, endCol - 1, 3)
            }
        }
        3 -> {// 左
            for (i in endCol downTo startCol) {
                result[tempResultIndex++] = array[endRow][i]
            }

            if (endRow - 1 >= startRow) {
                printRowOrCol(array, result, tempResultIndex, startRow, endRow - 1, startCol, endCol, 1)
            }
        }
        4 -> {// 右
            for (i in startCol..endCol) {
                result[tempResultIndex++] = array[startRow][i]
            }

            if (startRow + 1 <= endRow) {
                printRowOrCol(array, result, tempResultIndex, startRow + 1, endRow, startCol, endCol, 2)
            } else {
                return
            }
        }
    }
}

fun main() {
    printMatrix(
        arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 10, 11, 12),
//            intArrayOf(13, 14, 15, 16),
//            intArrayOf(1, 2, 3, 4),
//            intArrayOf(5, 6, 7, 8),
//            intArrayOf(9, 10, 11, 12),
        )
    ).contentToString().let(::println)
}