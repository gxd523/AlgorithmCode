package com.code.datastructure.link

/**
 * 剑指题：24
 * 反转链表
 */
fun reverseList(head: ListNode?): ListNode? {
    if (head == null) {
        return head
    }

    val reverseHead = recurseLinkReverse(head)
    head.next = null
    return reverseHead
}

fun recurseLinkReverse(node: ListNode): ListNode {
    val next = node.next ?: return node

    val head = recurseLinkReverse(next)
    next.next = node
    return head
}