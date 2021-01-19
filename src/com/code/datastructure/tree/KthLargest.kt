package com.code.datastructure.tree

/**
 * 剑指题：54
 * 二叉搜索树的第k大节点
 * 二叉搜索树的中序遍历是递增打印节点，调整一下，右、根、左，就是递减顺序打印了
 */
class KthLargest {
    var count = 0
    var result = 0
    fun kthLargest(root: TreeNode?, k: Int): Int {
        count = k
        inorderDfsKth(root)
        return result
    }

    private fun inorderDfsKth(root: TreeNode?) {
        if (root == null || result != 0) {
            return
        }
        inorderDfsKth(root.right)
        if (--count == 0) {
            result = root.value
            return
        }
        inorderDfsKth(root.left)
    }
}