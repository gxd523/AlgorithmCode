package com.code.algorithm.partition

/**
 * 乐扣：241
 * 位运算符表达式设计优先级，返回所有结果集合
 */
fun diffWaysToCompute(input: String): List<Int> {
    val list = emptyList<Int>().toMutableList()

    if (!input.contains('+') && !input.contains('-') && !input.contains('*')) {// 拆分到只有数字时，添加到集合返回
        list.add(input.toInt())
        return list
    }

    for (i in input.indices) {
        if ('+' == input[i] || '-' == input[i] || '*' == input[i]) {// 先遍历字符串的每个运算符，分成运算符左右两部分，分治
            val leftList = diffWaysToCompute(input.substring(0, i))// 每部分继续重复这个过程
            val rightList = diffWaysToCompute(input.substring(i + 1))

            for (left in leftList) {
                for (right in rightList) {// 遍历左边的集合，每一次循环中遍历右边集合，算出结果
                    list += when (input[i]) {
                        '+' -> left + right
                        '-' -> left - right
                        else -> left * right
                    }
                }
            }
        }
    }

    return list
}