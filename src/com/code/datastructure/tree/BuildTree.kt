package com.code.datastructure.tree

/**
 * 剑指题：7
 * 根据前序遍历、中序遍历重建二叉树
 */
fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    if (preorder.isEmpty()) {
        return null
    }
    val root = TreeNode(preorder[0])
    recurseBuildTree(root, preorder, inorder)
    return root
}

fun recurseBuildTree(root: TreeNode, preorder: IntArray, inorder: IntArray) {
    var rootPosInInorder = 0
    for (i in inorder.indices) {
        if (preorder[0] == inorder[i]) {
            rootPosInInorder = i
            break
        }
    }

    val leftLength = rootPosInInorder
    val rightLength = inorder.size - leftLength - 1

    if (leftLength > 0) {
        val leftPreorder = IntArray(leftLength)
        System.arraycopy(preorder, 1, leftPreorder, 0, leftLength)
        val leftInorder = IntArray(leftLength)
        System.arraycopy(inorder, 0, leftInorder, 0, leftLength)

        val left = TreeNode(leftPreorder[0])
        root.left = left
        recurseBuildTree(left, leftPreorder, leftInorder)
    }

    if (rightLength > 0) {
        val rightPreorder = IntArray(rightLength)
        System.arraycopy(preorder, 1 + leftLength, rightPreorder, 0, rightLength)
        val rightInorder = IntArray(rightLength)
        System.arraycopy(inorder, leftLength + 1, rightInorder, 0, rightLength)
        val right = TreeNode(rightPreorder[0])
        root.right = right
        recurseBuildTree(right, rightPreorder, rightInorder)
    }
}

fun main() {
    buildTree(
        intArrayOf(3, 9, 20, 15, 7),
        intArrayOf(9, 3, 15, 20, 7)
    ).let(::println)
}