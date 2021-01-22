package com.code.datastructure.queue

import java.util.*

/**
 * 剑指题：59
 * 滑动窗口的最大值
 * 单调双向队列：单调：递增或者递减，双向队列，两端都可以进出的队列
 */
fun maxSlidingWindow(array: IntArray, k: Int): IntArray {
    if (k < 1 || array.isEmpty()) {
        return emptyArray<Int>().toIntArray()
    }

    val result = IntArray(array.size - k + 1)
    val queue = LinkedList<Int>()// 单调双向队列，存放长度为k的array下标窗口

    for (i in array.indices) {
        while (queue.isNotEmpty() && array[queue.peekLast()] <= array[i]) {
            queue.pollLast()// 为保证窗口队列递减排列(即队列元素作为array下标对应的值)，插入下标对应array的值如果大于队尾，则弹出队尾元素，直到满足条件
        }

        queue.addLast(i)// 注意，入队的时array的下标，比较的是下标对应的元素的大小

        if (queue.peekFirst() == i - k) {// 如果队头的下标已经不在窗口下标范围内了，则将头部元素弹出
            queue.pollFirst()
        }

        if (i - k + 1 >= 0) {// 看看窗口有没有形成，例如k=3，当i移动到2时，才形成第一个窗口[0,1,2]，只有形成了大小为 k 的窗口，才能收集窗口内的最大值
            result[i - k + 1] = array[queue.peekFirst()]
        }
    }

    return result
}

fun main() {
    maxSlidingWindow(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3).contentToString().let(::println)
}