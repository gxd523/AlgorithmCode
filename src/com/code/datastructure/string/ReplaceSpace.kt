package com.code.datastructure.string

/**
 * 剑指题5
 * 将一个字符串中的空格替换成 "%20"。
 */
fun replace(str: String): String {
    var p1 = str.length - 1// p1指向原数组的最后一个元素
    var p2 = p1
    for (i in str.indices) {
        if (str[i] == ' ') {
            p2 += 2// p2指向转化后数组的最后一个元素
        }
    }
    // 先创建能装下转换后字符新数组
    val charArray = CharArray(p2 + 1)
    // 复制原有内容到新数组
    System.arraycopy(str.toCharArray(), 0, charArray, 0, str.length)

    while (p1 != p2) {// 倒序将原数组的元素移入新数组
        when {
            str[p1] == ' ' -> {// 如果原数组是空格，新数组的指针p2前移3位，别忘了原数组的指针p1也要前移1位
                charArray[p2--] = '0'
                charArray[p2--] = '2'
                charArray[p2--] = '%'
                p1--
            }
            else -> charArray[p2--] = str[p1--]// 如果原数组不是空格，新、老数组的指针都前移1位
        }
    }
    return String(charArray)
}

fun main() {
    val str = "We all happy."
    replace(str).let(::println)
}