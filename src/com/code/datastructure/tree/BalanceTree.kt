package com.code.datastructure.tree

import kotlin.math.abs
import kotlin.math.max

/**
 * 剑指题：55
 * 判断平衡二叉树
 * 如果二叉树中任意节点的左右子树的深度差<2，那么它就是一棵平衡二叉树
 */
fun isBalanced(root: TreeNode?): Boolean {
    return postorderDfsBalance(root) != -1
}

/**
 * 返回值为-1，表示子树深度差>=2，为非平衡二叉树，否则返回深度
 */
fun postorderDfsBalance(root: TreeNode?): Int {
    if (root == null) return 0

    val left = postorderDfsBalance(root.left)// 返回值表示子树的深度
    if (left == -1) return -1

    val right = postorderDfsBalance(root.right)
    if (right == -1) return -1

    return if (abs(left - right) < 2)
        max(left, right) + 1 // 当前节点往下的深度为，左右子树中深度更大的再+1(1就是当前节点)
    else
        -1
}