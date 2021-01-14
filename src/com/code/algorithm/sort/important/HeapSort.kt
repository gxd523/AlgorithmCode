package com.code.algorithm.sort.important

import com.code.algorithm.sort.simple.swap

/**
 * 堆排序
 *
 * 假设有k层，k-1层的每个节点需要向下比较1次，k-2层的每个节点需要向下比较2次...1层需要比较k-1次
 * 假设有k层，第1层有1个节点...第k层有2^(k-1)个节点
 * 每一次层的节点数x该层节点的比较次数，即为总比较次数：2^(1-1)x(k-1) + 2^(2-1)x(k-2) +...+ 2^(k-1)x0
 * 二叉树层数k,与最大节点数n,满足关系：n = 2^(k)-1，也就是：k = log₂(n + 1)
 * 得到总比较次数：1x
 * 时间复杂度：O(nlog₂n)
 * 控件复杂度：O(1)
 * 第x层二叉树，最多有2ˣ⁻¹个节点
 */
fun heap(array: IntArray) {
    for (i in getLastParent(array.size) downTo 0) {
        adjustHeap(array, i, array.size)
    }

    for (j in array.size - 1 downTo 1) {
        swap(array, j, 0)
        adjustHeap(array, 0, j)
    }
}

fun adjustHeap(array: IntArray, i: Int, j: Int) {
    var l = getLeftChild(i)
    while (l < j) {
        if (l + 1 < j && array[l] < array[l + 1]) {// 如果有右子，从左右子中选出大的
            l++
        }
        val parentIndex = getParent(l)
        if (array[l] > array[parentIndex]) {
            swap(array, l, parentIndex)
            l = getLeftChild(l)// 交换父子节点后，需要继续向下调整，子节点的子节点
        } else {// 如果没交换父子节点，就不用继续向下调整
            break
        }
    }
}

fun getParent(i: Int): Int = (i - 1) / 2

fun getLeftChild(i: Int): Int = i * 2 + 1

fun getLastParent(size: Int): Int = size / 2 - 1

fun main() {
    intArrayOf(8, 3, 2, 7, 5, 6, 4, 1).apply(::heap).contentToString().let(::println)
}