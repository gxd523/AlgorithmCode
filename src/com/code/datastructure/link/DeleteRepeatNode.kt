package com.code.datastructure.link

/**
 * 剑指题：18.2
 * 删除重复元素，例如：1,2,3,3->1,2
 * todo 不好做
 * 分两种情况：
 * 第一种情况：1,1,2，前几个重复，往后找到和前几个不相等的，这种只能排除前面重复的，对于后面的还要继续递归
 * 第二种情况：1,2，前两个不相同，此时第一个保留，后面的继续递归
 */
fun deleteDuplicates(head: ListNode?): ListNode? {
    if (head?.next == null) {// 如果head为空，或者链表只有一个元素，就返回head
        return head
    }

    var next = head.next
    var result = head

    if (head.value == next!!.value) {// 子链的前两个重复
        while (next != null && head.value == next.value) {
            next = next.next// next右移到和head不相等的元素
        }
        result = deleteDuplicates(next)// 子链的前几个重复，从不重复的元素开始继续递归，注意这个不重复的元素只是和前面不重复，与后面的数重复重复要递归判断
    } else {// 子链的前两个不相等，只能说面第一个不重复
        result.next = deleteDuplicates(next)
    }
    return result
}