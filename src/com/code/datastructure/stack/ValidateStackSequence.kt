package com.code.datastructure.stack

import java.util.*

/**
 * 剑指题：31
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 */
fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
    val stack = Stack<Int>()
    var popIndex = 0
    for (e in pushed) {
        stack.push(e)
        // 如果栈顶元素和popIndex对应的元素不相等，遍历pushed剩余的元素放入栈中
        // 依次对比popIndex对应的元素，如果遍历完了都不相等，就说明无法实现popped的出栈顺序
        while (stack.isNotEmpty() && stack.peek() == popped[popIndex]) {
            stack.pop()
            popIndex++
        }
    }
    return stack.isEmpty()
}

fun main() {
    validateStackSequences(
        intArrayOf(1, 2, 3, 4, 5),
        intArrayOf(4, 3, 5, 1, 2),
    ).let(::println)
}