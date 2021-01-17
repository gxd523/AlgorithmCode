package com.code.datastructure.tree

import java.util.*

/**
 * 广度优先遍历
 * 利用了队列先进后出的特点，减少了每层队列的创建
 */
fun breadthTraversal(list: MutableList<MutableList<Int>>, currentLayerNodeQueue: Queue<TreeNode>) {
    if (currentLayerNodeQueue.isEmpty()) {
        return
    }

    val currentLayerValueList = emptyList<Int>().toMutableList()
    for (i in currentLayerNodeQueue.indices) {// 遍历当前层的节点，值存入list，左右子节点顺序存入下一层节点集合
        val node = currentLayerNodeQueue.poll()
        currentLayerValueList.add(node.value)

        node.left?.let { left ->
            currentLayerNodeQueue.add(left)
        }
        node.right?.let { right ->
            currentLayerNodeQueue.add(right)
        }
    }
    list.add(currentLayerValueList)
    breadthTraversal(list, currentLayerNodeQueue)
}

/**
 * 剑指题：32
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行
 * 递归过程中，函数参数都有当前在第几层，这样每个节点都能根据自己所在层数找到list对应的层子集合
 */
fun breadthTraversalBetter(list: MutableList<MutableList<Int>>, layer: Int, root: TreeNode?) {
    if (root == null) {
        return
    }
    if (list.size == layer) {
        list.add(emptyArray<Int>().toMutableList())
    }
    list[layer].add(root.value)
    breadthTraversalBetter(list, layer + 1, root.left)
    breadthTraversalBetter(list, layer + 1, root.right)
}

fun main() {
    emptyList<MutableList<Int>>()
        .toMutableList()
        .also { list ->
            val root = createTree(intArrayOf(0, 1, 2, 3, 4, 5, 6))
            breadthTraversalBetter(list, 0, root)
        }
        .let(::println)

    emptyList<MutableList<Int>>()
        .toMutableList()
        .also { list ->
            val root = createTree(intArrayOf(0, 1, 2, 3, 4, 5, 6))
            breadthTraversal(list, LinkedList<TreeNode>().apply { add(root) })
        }
        .let(::println)
}