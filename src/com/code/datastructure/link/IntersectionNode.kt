package com.code.datastructure.link

/**
 * 剑指题：52
 * 找出两个链的第一个公共节点
 * 注意：也可能没有
 */
fun findIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
    var nodeA = headA
    var nodeB = headB
    while (nodeA != nodeB) {
        // nodeA走完A节点走B节点，妙在判断nodeA是否为null，而不是nodeA.next，这样即使两条链没有公共节点，也会同时为null，返回
        nodeA = if (nodeA == null) headB else nodeA.next
        nodeB = if (nodeB == null) headA else nodeB.next// nodeB走完B节点走A节点
    }
    return nodeA// 当相遇时，nodeA走了a+c+b，nodeB走了b+c+a，所以相遇时刚好为第一个公共节点
}