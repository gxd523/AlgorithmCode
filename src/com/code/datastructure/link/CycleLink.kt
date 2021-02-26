package com.code.datastructure.link

/**
 * 力扣：141
 * 判断链表中是否有环
 */
fun hasCycle(head: ListNode?): Boolean {
    if (head?.next == null) {
        return false
    }
    var slow = head
    var fast = head
    while (true) {
        if (slow == null || fast == null || fast.next == null) {
            return false
        }
        slow = slow.next
        fast = fast.next!!.next
        if (slow == fast) {
            return true
        }
    }
}