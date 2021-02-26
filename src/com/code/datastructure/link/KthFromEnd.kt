package com.code.datastructure.link

/**
 * 剑指题：22
 * 妙妙题
 * 链表中倒数第k个节点
 */
class KthFromEnd {
    var countdown = 0
    var result: ListNode? = null

    fun getKthFromEnd(head: ListNode?, k: Int): ListNode? {
        countdown = k
        recurseLinkKth(head)
        return result
    }

    private fun recurseLinkKth(node: ListNode?) {
        if (node == null) return

        recurseLinkKth(node.next)
        if (--countdown == 0) result = node
    }
}