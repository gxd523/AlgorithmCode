package com.code.datastructure.stack

import java.util.*

/**
 * 剑指题：9
 * 用两个栈实现一个队列。
 * 队列的声明如下，请实现它的两个函数appendTail和deleteHead，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回-1)
 */
class StackQueue {
    private val appendStack = Stack<Int>()
    private val deleteStack = Stack<Int>()

    fun appendTail(value: Int): Int = appendStack.push(value)

    fun deleteHead(): Int = if (deleteStack.isEmpty()) {
        if (appendStack.isEmpty()) {
            -1
        } else {// deleteStack全部出栈后，再从appendStack入栈元素
            while (appendStack.isNotEmpty()) {
                deleteStack.push(appendStack.pop())
            }
            deleteStack.pop()
        }
    } else {
        deleteStack.pop()
    }
}

fun main() {
    val stackQueue = StackQueue()
    intArrayOf(
        stackQueue.deleteHead(),
        stackQueue.appendTail(1),
        stackQueue.appendTail(2),
        stackQueue.deleteHead(),
        stackQueue.appendTail(3),
        stackQueue.deleteHead(),
    ).contentToString().let(::println)
}