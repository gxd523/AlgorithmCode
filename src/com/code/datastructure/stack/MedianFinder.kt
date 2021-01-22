package com.code.datastructure.stack

import com.code.algorithm.sort.important.getLeftChild
import com.code.algorithm.sort.important.getParent
import java.util.*

/**
 *  剑指题：41
 *  数据流中的中位数
 *  方法一：使用左边小顶堆，右边大顶堆，左边所有的数都比右边所有的数大
 *  当左右大小相等时，新值先插入大顶堆，再从大顶堆取出最大值，插入小顶堆，O(logN) + O(logN)
 *  当左右大小不相等时(也就是小顶堆比大顶堆多一个数)，新值先插入小顶堆，再从小顶堆取出最小值，插入大顶堆，O(logN) + O(logN)
 *  取中位数：左右大小不相等时，取小顶堆的最小值，否则，取小顶堆的最小值和大顶堆的最大值的平均值，O(1)
 */
class MedianFinder {
    private val smallTop = PriorityQueue<Int> { o1, o2 -> o1 - o2 }
    private val bigTop = PriorityQueue<Int> { o1, o2 -> o2 - o1 }

    fun addNum(num: Int) {
        if (smallTop.size != bigTop.size) {
            smallTop.offer(num)
            bigTop.offer(smallTop.poll())
        } else {
            bigTop.offer(num)
            smallTop.offer(bigTop.poll())
        }
    }

    fun findMedian(): Double {
        return if (smallTop.size != bigTop.size) smallTop.peek().toDouble() else (smallTop.peek() + bigTop.peek()) / 2.0
    }
}

/**
 *  剑指题：41
 *  数据流中的中位数
 *  自己实现大小顶堆
 */
class MedianFinder1 {
    private val smallTop = emptyList<Int>().toMutableList()
    private val bigTop = emptyList<Int>().toMutableList()

    fun addNum(num: Int) {
        if (smallTop.size != bigTop.size) {
            val smallestInSmallTop: Int
            if (num <= smallTop[0]) {
                smallestInSmallTop = num
            } else {
                smallestInSmallTop = smallTop[0]
                smallTop[0] = num
                adjustHeapFromTop(false, smallTop, 0, smallTop.size)
            }
            bigTop.add(smallestInSmallTop)
            adjustHeapFromBottom(true, bigTop, bigTop.size - 1)
        } else {
            if (smallTop.size == 0) {
                smallTop.add(num)
                return
            }

            val biggestInBigTop: Int
            if (num > bigTop[0]) {
                biggestInBigTop = num
            } else {
                biggestInBigTop = bigTop[0]
                bigTop[0] = num
                adjustHeapFromTop(true, bigTop, 0, bigTop.size)
            }
            smallTop.add(biggestInBigTop)
            adjustHeapFromBottom(false, smallTop, smallTop.size - 1)
        }
    }

    private fun adjustHeapFromTop(bigHeap: Boolean, list: MutableList<Int>, i: Int, length: Int) {
        var j = getLeftChild(i)
        while (j < length) {
            if (j + 1 < length) {
                if (bigHeap && list[j + 1] > list[j] || !bigHeap && list[j + 1] < list[j]) {
                    j += 1
                }
            }
            val parentIndex = getParent(j)
            if (bigHeap && list[parentIndex] < list[j] || !bigHeap && list[parentIndex] > list[j]) {
                swap(list, parentIndex, j)
                j = getLeftChild(j)
            } else {
                break
            }
        }
    }

    private fun adjustHeapFromBottom(bigHeap: Boolean, list: MutableList<Int>, i: Int) {
        var j = i
        while (getParent(i) >= 0) {
            val parentIndex = getParent(j)
            if (bigHeap && list[parentIndex] < list[j] || !bigHeap && list[parentIndex] > list[j]) {
                swap(list, parentIndex, j)
                j = parentIndex
            } else {
                break
            }
        }
    }

    private fun swap(list: MutableList<Int>, i: Int, j: Int) {
        val temp = list[j]
        list[j] = list[i]
        list[i] = temp
    }

    fun findMedian(): Double {
        return if (smallTop.size != bigTop.size) smallTop[0].toDouble() else (smallTop[0] + bigTop[0]) / 2.0
    }
}

/**
 *  剑指题：41
 *  数据流中的中位数
 *  方法二：添加数据时，折半查找有序数列，时间复杂度O(logN)，并插入数据，时间复杂度O(N)，总体O(N)
 *  取数据：O(1)
 */
class MedianFinder2 {
    private val list = emptyList<Int>().toMutableList()

    fun addNum(num: Int) {
        val index = halfSearch(num, 0, list.size)
        list.add(index, num)
    }

    private fun halfSearch(target: Int, start: Int, end: Int): Int {
        if (start == end) return start // 如果集合中没有要找的数，在这里返回start，就是集合插入的index

        val half = (start + end) / 2
        return when {
            list[half] > target -> halfSearch(target, start, half)
            list[half] < target -> halfSearch(target, half + 1, end)
            else -> half
        }
    }

    fun findMedian(): Double {
        return if (list.size % 2 == 0) {
            (list[list.size / 2 - 1] + list[list.size / 2]) / 2.0
        } else {
            list[list.size / 2].toDouble()
        }
    }
}

fun main() {
    val medianFinder = MedianFinder1()
    intArrayOf(
        78, 14, 50, 20, 13, 9, 25, 8, 13, 37
    ).forEach {
        medianFinder.addNum(it)
        medianFinder.findMedian().let(::println)
    }
}