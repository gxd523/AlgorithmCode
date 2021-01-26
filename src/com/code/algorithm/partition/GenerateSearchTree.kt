package com.code.algorithm.partition

import com.code.datastructure.tree.TreeNode

/**
 * 乐扣题：95
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树
 * todo 难题
 */
fun generateSearchTree(n: Int): List<TreeNode?> {
    return generateSearchTree(4, n)
}

fun generateSearchTree(start: Int, end: Int): List<TreeNode?> {
    val list = emptyList<TreeNode?>().toMutableList()

    if (start > end) {
        list += null// 注意这里没有节点了要加入null，否则leftNodeList、rightNodeList有一个为空另一个就没法循环了
        return list
    }

    for (i in start..end) {// 每一个数都可以作为根节点，所以遍历
        val leftNodeList = generateSearchTree(start, i - 1)
        val rightNodeList = generateSearchTree(i + 1, end)
        for (leftNode in leftNodeList) {
            for (rightNode in rightNodeList) {
                list += TreeNode(i, leftNode, rightNode)
            }
        }
    }

    return list
}

fun main() {
    generateSearchTree(3).forEach { println(it) }
}