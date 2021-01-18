package com.code.datastructure.tree

import java.util.*

/**
 * 广度优先遍历
 * 利用了队列先进后出的特点，减少了每层队列的创建
 */
fun recurseBfs(list: MutableList<MutableList<Int>>, currentLayerNodeQueue: Queue<TreeNode>) {
    if (currentLayerNodeQueue.isEmpty()) {
        return
    }

    val currentLayerValueList = emptyList<Int>().toMutableList()
    for (i in currentLayerNodeQueue.indices) {// 遍历当前层的节点，值存入list，左右子节点顺序存入下一层节点集合
        val node = currentLayerNodeQueue.poll()
        currentLayerValueList += node.value

        node.left?.let { left ->
            currentLayerNodeQueue += left
        }
        node.right?.let { right ->
            currentLayerNodeQueue += right
        }
    }
    list += currentLayerValueList
    recurseBfs(list, currentLayerNodeQueue)
}

/**
 * 剑指题：32.2
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行
 * 递归过程中，函数参数都有当前在第几层，这样每个节点都能根据自己所在层数找到list对应的层子集合
 */
fun recurseBfsBetter(list: MutableList<MutableList<Int>>, layer: Int, root: TreeNode?) {
    if (root == null) {
        return
    }
    if (list.size == layer) {
        list += emptyArray<Int>().toMutableList()
    }
    list[layer].add(root.value)
    recurseBfsBetter(list, layer + 1, root.left)
    recurseBfsBetter(list, layer + 1, root.right)
}

/**
 * 迭代实现广度优先遍历
 */
fun iterateBfs(root: TreeNode): List<List<Int>> {
    val list = emptyList<MutableList<Int>>().toMutableList()

    val queue = LinkedList<TreeNode>()
    queue += root

    while (queue.isNotEmpty()) {
        list += emptyList<Int>().toMutableList()

        repeat(queue.size) {
            val node = queue.poll()
            list.last() += node.value
            node.left?.let(queue::add)
            node.right?.let(queue::add)
        }
    }
    return list
}

fun main() {
    emptyList<MutableList<Int>>()
        .toMutableList()
        .also { list ->
            val root = createTree(intArrayOf(0, 1, 2, 3, 4, 5, 6))
            recurseBfsBetter(list, 0, root)
        }
        .let(::println)

    emptyList<MutableList<Int>>()
        .toMutableList()
        .also { list ->
            val root = createTree(intArrayOf(0, 1, 2, 3, 4, 5, 6))
            recurseBfs(list, LinkedList<TreeNode>().apply { add(root) })
        }
        .let(::println)

    createTree(intArrayOf(0, 1, 2, 3, 4, 5, 6)).let(::iterateBfs).let(::println)
}