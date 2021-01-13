package com.code.datastructure.stack

import java.util.*
import kotlin.math.min

/**
 * 剑指题：30
 * 定义栈的数据结构
 * 请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
class MinStack {
    private val stack = Stack<Int>()
    private val minStack = Stack<Int>()

    fun push(x: Int) {
        stack.push(x)
        minStack.push(if (minStack.isEmpty()) x else min(x, minStack.peek()))
    }

    fun pop() {
        stack.pop()
        minStack.pop()
    }

    fun top(): Int {
        return stack.peek()
    }

    fun min(): Int {
        return minStack.peek()
    }
}

fun main() {
    val minStack = MinStack()
    arrayOf(
        minStack.push(-2),
        minStack.push(0),
        minStack.push(-3),
        minStack.min(),
        minStack.pop(),
        minStack.top(),
        minStack.min(),
    ).contentToString().let(::println)
}