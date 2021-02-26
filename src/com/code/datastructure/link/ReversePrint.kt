package com.code.datastructure.link

/**
 * 剑指题：6
 * 从尾到头打印单链表
 */
fun reversePrint(head: ListNode?): IntArray {
    val list = emptyList<Int>().toMutableList()
    recurseSingleLink(head, list)
    return list.toIntArray()
}

/**
 * 利用递归回溯时(有类似栈先进后出的特点)，加入节点，从而倒序链表
 */
fun recurseSingleLink(node: ListNode?, list: MutableList<Int>) {
    if (node == null) {
        return
    }
    recurseSingleLink(node.next, list)
    list += node.value
}
