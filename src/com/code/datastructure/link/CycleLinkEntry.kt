package com.code.datastructure.link

/**
 * 剑指题：23
 * 力扣：142
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
 *
 * 双指针，fast比slow每次多走一步，如果链表有环，则一定能相遇
 * fast、slow第一次相遇时，fast走的步数时slow的2倍(f=2s)，fast比slow多走了n圈才能追上(f-s=n圈)
 * 所以得到结论：slow走n圈、fast走2n圈时，fast、slow第一次相遇
 * 从head到入口要走a步，如果走a+n圈也可以回到入口节点，目前slow已经走了n圈
 * 此时fast置为head，向入口走，slow继续转圈，fast、slow都再走a步，就都到达了入口，也就是相遇了
 */
fun detectCycle(head: ListNode?): ListNode? {
    if (head?.next == null) return null

    var slow = head
    var fast = head
    while (true) {
        if (slow == null || fast == null || fast.next == null) return null
        slow = slow.next
        fast = fast.next!!.next

        if (slow == fast) break
    }
    fast = head
    while (slow != fast) {
        slow = slow!!.next
        fast = fast!!.next
    }
    return fast
}