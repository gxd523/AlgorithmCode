package com.code.datastructure.link

/**
 * 剑指题：25
 * 合并两个排序链表
 * 双指针遍历两个链表
 */
fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    val head = ListNode(0)// 这可加了个伪head，方便tail不为空
    var tail: ListNode = head

    var link1: ListNode? = l1
    var link2: ListNode? = l2
    while (link1 != null && link2 != null) {
        if (link1.value < link2.value) {
            tail.next = link1
            link1 = link1.next
        } else {
            tail.next = link2
            link2 = link2.next
        }
        tail = tail.next!!
    }
    tail.next = link1 ?: link2// 这里很妙，如果一个链表遍历完了，只用和另一个链表未遍历的剩余部分接起来就行了，剩余部分也是排好序的
    return head.next
}