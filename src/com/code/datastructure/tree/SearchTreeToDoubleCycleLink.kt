package com.code.datastructure.tree

/**
 * 剑指题：36
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 */
class SearchTreeToDoubleCycleLink {
    var headNode: TreeNode? = null// 递归时不方便来回传递的参数，就用成员变量
    var preNode: TreeNode? = null

    fun toDoubleLink(root: TreeNode): TreeNode {
        inorderDfs(root)
        preNode!!.right = headNode
        headNode!!.left = preNode
        return headNode!!
    }

    /**
     * 先利用中序遍历能够将二叉搜索树递增打印的特点
     */
    private fun inorderDfs(curNode: TreeNode?) {
        if (curNode == null) {
            return
        }
        inorderDfs(curNode.left)

        traversalNodeIncreaseOrder(curNode)

        inorderDfs(curNode.right)
    }

    /**
     * 搜索二叉树的节点从小到大一次传入该方法
     */
    private fun traversalNodeIncreaseOrder(curNode: TreeNode) {
        if (preNode == null) {// 第一个节点传入此方法时，preNode还没赋过值，以此判断head节点
            headNode = curNode
        } else {
            preNode!!.right = curNode
        }
        curNode.left = preNode
        preNode = curNode// 方法结束时，给preNode赋值当前节点node，供下一次调用此方法使用
    }
}