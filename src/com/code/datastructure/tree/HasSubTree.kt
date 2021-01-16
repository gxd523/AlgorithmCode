package com.code.datastructure.tree

/**
 * 剑指题：26
 * 输入两棵二叉树A和B，判断B是不是A的子结构。
 * 约定空树不是任意一个树的子结构
 * 注意：不一定是完全二叉树，不能用DFS
 */
fun isSubStructure(A: TreeNode?, B: TreeNode?): Boolean {
    if (A == null || B == null) return false
    return findStartNode(A, B)
}

/**
 * 寻找A中和B的根节点值相同的节点，然后开始往下比较
 */
fun findStartNode(A: TreeNode?, B: TreeNode): Boolean {
    if (A == null) return false
    return recurseTree(A, B) || findStartNode(A.left, B) || findStartNode(A.right, B)
}

fun recurseTree(A: TreeNode?, B: TreeNode?): Boolean {
    if (B == null) return true
    if (A == null || A.value != B.value) return false
    return recurseTree(A.left, B.left) && recurseTree(A.right, B.right)
}