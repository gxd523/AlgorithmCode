package com.code.algorithm.dfs

/**
 * 剑指题：38
 * 打印字符串的所有排列，不能有重复字符串
 * 注意：可能存在如abb，这样的字符串，会导致排列结果重复
 * todo 超难
 */
fun permutation(s: String): Array<String> {
    val list = emptyList<String>().toMutableList()
    val word = CharArray(s.length)
    dfsPermutation(list, word, s.toCharArray(), 0)
    return list.toTypedArray()
}

fun dfsPermutation(list: MutableList<String>, word: CharArray, array: CharArray, k: Int) {
    if (k == array.size) {
        list += String(word)// 这里不能加list.contains()，会很耗时，要么使用HashSet天然去重
        return
    }

    val set = HashSet<Char>()
    for (i in k until array.size) {
        if (set.contains(array[i])) {// 或者在这里跳过重复的元素
            continue
        }
        set.add(array[i])

        word[k] = array[i]

        if (i != k) {
            swapCharArr(array, i, k)// 这里很重要，如果从遍历到k后面的数字，下一层dfs是从k+1开始的，所以这里很巧妙的交换了一下，让下一层顺着往下就能遍历剩余的元素
        }

        dfsPermutation(list, word, array, k + 1)

        if (i != k) {
            swapCharArr(array, i, k)
        }
    }
}

fun swapCharArr(array: CharArray, m: Int, n: Int) {
    val temp = array[n]
    array[n] = array[m]
    array[m] = temp
}