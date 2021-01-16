package com.code.datastructure.tree

/**
 * 剑指题：28
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。
 * 如果一棵二叉树和它的镜像一样，那么它是对称的。
 */
fun isSymmetry(root: TreeNode?): Boolean {
    return root == null || recurseSymmetryCompare(root.left, root.right)
}

/**
 * 对称二叉树的规律：
 * root.left == root.right
 * root.left.left == root.right.right
 */
fun recurseSymmetryCompare(left: TreeNode?, right: TreeNode?): Boolean {
    if (left == null && right == null) return true
    if (left == null || right == null || left.value != right.value) return false
    return recurseSymmetryCompare(left.left, right.right) && recurseSymmetryCompare(left.right, right.left)
}
