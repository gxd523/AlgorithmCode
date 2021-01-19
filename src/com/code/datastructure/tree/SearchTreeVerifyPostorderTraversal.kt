package com.code.datastructure.tree

/**
 * 剑指题：33
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 二叉搜索树：左子树的所有节点<根节点，右子树所有节点>根节点，左右子树也满足以上条件，任意两个节点的值都不同
 */
fun verifyPostorder(postorder: IntArray): Boolean {
    return recurseSearchTree(postorder, 0, postorder.size - 1)
}

fun recurseSearchTree(postorder: IntArray, start: Int, end: Int): Boolean {
    if (start + 1 >= end) {
        return true
    }
    var rightChildStartIndex = start
    while (postorder[rightChildStartIndex] < postorder[end]) rightChildStartIndex++// 先从左开始找到比最后一个节点(也就是根节点)，假定为子树的分界线
    var temp = rightChildStartIndex
    while (postorder[temp] > postorder[end]) temp++// 从分界线开始直到最后一个节点(也就是根节点)，应该都是比根节点大的才对
    return temp == end
            && recurseSearchTree(postorder, start, rightChildStartIndex - 1)// 左右子树要依然满足二叉搜索树的条件
            && recurseSearchTree(postorder, rightChildStartIndex, end - 1)
}
