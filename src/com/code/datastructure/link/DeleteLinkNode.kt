package com.code.datastructure.link

/**
 * 剑指题：18
 * 删除某个值所对应的节点
 */
fun deleteNode(head: ListNode?, value: Int): ListNode? {
    if (head == null) {
        return null
    }
    if (head.value == value) {
        return head
    }
    var preNode = head
    while (preNode!!.next != null) {
        val curNode = preNode.next
        if (curNode!!.value == value) {
            preNode.next = curNode.next
            break
        }
        preNode = curNode
    }
    return head
}

/**
 * 剑指题：18.1
 * 在O(1)时间内删除链表节点
 */
fun deleteNode(head: ListNode, delete: ListNode): ListNode? {
    if (head.next == null) return null

    val deleteNextNode = delete.next
    if (deleteNextNode == null) {// 如果delete是尾节点，此时的时间复杂度是O(N)
        var node = head

        while (node.next != deleteNextNode) node = node.next!!

        node.next = null// 和尾节点断开
    } else { // 如果delete不是尾结点，巧妙和delete的下一个节点交换值，然后把下一个节点删掉，这样就不用从head找delete的上一个节点了
        // 此时的时间复杂度是O(1)
        delete.value = deleteNextNode.value
        delete.next = deleteNextNode.next
    }
    return head
}