package com.code.datastructure.link

/**
 * 剑指题：35
 * 复制链表，链表多一个random指针
 */
data class ComplexNode(var value: Int, var next: ComplexNode? = null, var random: ComplexNode? = null)

fun copyComplexLink(head: ComplexNode?): ComplexNode? {
    if (head == null) return head

    var tail = head
    while (tail != null) {// 第一步合并原链表、复制的新链表，新链表的每个元素跟在原链表的每个元素的后面
        val newNode = ComplexNode(tail.value)
        newNode.next = tail.next
        tail.next = newNode
        tail = newNode.next
    }

    tail = head
    while (tail?.next != null) {// 第二步：给合并链表的新元素的random赋值
        if (tail.random != null) {
            tail.next!!.random = tail.random
        }
        tail = tail.next!!.next
    }

    val newHead = head.next
    tail = newHead
    var orignalTail = head
    while (tail?.next != null && orignalTail?.next != null) {// 第三步：分离原链表、新链表
        orignalTail.next = tail.next
        orignalTail = orignalTail.next

        tail.next = orignalTail!!.next
        tail = tail.next
    }

    orignalTail?.next = null

    return newHead
}

fun main() {
    val head = ComplexNode(7)
    val e1 = ComplexNode(13)
    val e2 = ComplexNode(11)
    val e3 = ComplexNode(10)
    val e4 = ComplexNode(1)
    head.next = e1
    e1.next = e2
    e1.random = head
    e2.next = e3
    e2.random = e4
    e3.next = e4
    e3.random = e2
    e4.random = head

    var newHead = copyComplexLink(head)
    while (newHead != null) {
        print("[${newHead.value}, ${newHead.random?.value}], ")
        newHead = newHead.next
    }
    println("")
    newHead = copyComplexLink(head)
    while (newHead != null) {
        print("[${newHead.value}, ${newHead.random?.value}], ")
        newHead = newHead.next
    }
}