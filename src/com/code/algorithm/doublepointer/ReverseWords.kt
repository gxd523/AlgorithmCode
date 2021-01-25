package com.code.algorithm.doublepointer

/**
 * 剑指题：58.1
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 * 翻转每个单词，再翻转整个句子，同[leftRightSwap]
 */
fun reverseWords(s: String): String {
    if (s.trim().isEmpty()) {
        return ""
    }
    val array = s.trim().toCharArray()// 这一步很关键，剪去头尾的空格
    var p1 = 0
    var p2 = 0
    while (p2 < array.size) {
        if (array[p2] == ' ') {
            reverse(array, p1, p2 - 1)// 翻转每个单词
            while (array[p2] == ' ') {// 下一个单词的开始要以非空格开始
                p2++
            }
            p1 = p2// 每个单词的开头
        } else {
            if (p2 == array.size - 1) {// 注意到末尾时没有空格，只能通过判断最后一个元素确定最后一个单词
                reverse(array, p1, p2)
            }
            p2++
        }
    }

    reverse(array, 0, array.size - 1)// 最后再把整个句子翻转

    var n = 0
    for (i in 1 until array.size) {// 最后在遍历一遍句子，去除单词间多余的空格
        if (array[i] == ' ' && array[i - 1] == ' ') {// 空格的前一个如果也是空格则说明此空格多余
            n++
        } else {
            if (n > 0) {
                array[i - n] = array[i]// 如果不是多余空格则往前移动n个位置
            }
        }
    }

    return String(array.copyOfRange(0, array.size - n))// 最后拷贝前移数组的去除多余空格的长度
}

fun reverse(array: CharArray, m: Int, n: Int) {// 翻转操作
    var i = m
    var j = n
    while (i < j) {
        swap(array, i++, j--)
    }
}

/**
 * 这种好点
 */
fun reverseWords1(s: String): String {
    val str = s.trim()
    val builder = StringBuilder()
    var i = str.length - 1
    while (i >= 0) {
        val end = i
        while (i >= 0 && ' ' != str[i]) {
            i--
        }
        var j = i + 1
        while (j <= end) {
            builder.append(str[j])
            j++
        }
        if (i >= 0) {
            builder.append(' ')
        }
        while (i >= 0 && ' ' == str[i]) {
            i--
        }
    }
    return builder.toString()
}

fun main() {
    reverseWords(
        "I am a student. "
    ).let(::println)
}