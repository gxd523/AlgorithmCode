package com.code.datastructure.tree

/**
 * 剑指题：34
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * 注意路径要到最底下一层
 */
fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
    val list = emptyList<MutableList<Int>>().toMutableList()
    if (root == null) {
        return list
    }
    val path = emptyList<Int>().toMutableList()
    recursePathTree(list, root, sum, path)
    return list
}

fun recursePathTree(list: MutableList<MutableList<Int>>, root: TreeNode, sum: Int, path: MutableList<Int>) {
    var temp = sum

    path += root.value
    temp -= root.value

    if (sum == 0 && root.left == null && root.right == null) {
        list += ArrayList(path)
    }
    root.left?.let { left ->
        recursePathTree(list, left, sum, path)
    }
    path.removeAt(path.size - 1)
    root.right?.let { right ->
        recursePathTree(list, right, sum, path)
    }
    path.removeAt(path.size - 1)
}
