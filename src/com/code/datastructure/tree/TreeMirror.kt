package com.code.datastructure.tree

/**
 * 剑指题：27
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像
 * 注意：不是完全二叉树
 */
fun mirrorTree(root: TreeNode?): TreeNode? {
    recurseThisTree(root)
    return root
}

fun recurseThisTree(root: TreeNode?) {
    if (root == null) {
        return
    }
    swapNode(root)
    recurseThisTree(root.left)
    recurseThisTree(root.right)
}

fun swapNode(root: TreeNode) {// 注意：引用类型传递的是引用
    if (root.left == null && root.right == null) {
        return
    }
    val temp = root.right
    root.right = root.left
    root.left = temp
}
