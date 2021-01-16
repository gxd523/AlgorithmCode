package com.code.datastructure.tree

import com.code.algorithm.sort.important.getLeftChild

/**
 * 满二叉树：满足N = 2^(k) - 1
 * 完全二叉树：只有最底下一层的右边没填满
 */
data class TreeNode(
    val value: Int,
    var left: TreeNode? = null,
    var right: TreeNode? = null
)

/**
 * 广度遍历创建一个二叉树
 */
fun createTree(array: IntArray): TreeNode {
    val root = TreeNode(array[0])
    recurseCreateTree(array, root, 0)
    return root
}

fun recurseCreateTree(array: IntArray, root: TreeNode, rootIndex: Int) {
    val leftChildIndex = getLeftChild(rootIndex)
    if (leftChildIndex < array.size) {
        val leftNode = TreeNode(array[leftChildIndex])
        root.left = leftNode
        recurseCreateTree(array, leftNode, leftChildIndex)
        if (leftChildIndex + 1 < array.size) {
            val rightChild = TreeNode(array[leftChildIndex + 1])
            root.right = rightChild
            recurseCreateTree(array, rightChild, leftChildIndex + 1)
        }
    }
}