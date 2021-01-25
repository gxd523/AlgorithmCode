package com.code.algorithm.search

import com.code.algorithm.doublepointer.leftRightSwap
import com.code.algorithm.doublepointer.reverseWords

/**
 * 剑指题：11
 * 旋转数组的最小值
 * 折半查找与暴力遍历的结合版
 * 没有重复元素的时间复杂度：O(log2(N))，重复元素的时间复杂度：O(N)
 * 有一点神似字符串翻转[reverseWords]、字符串左旋[leftRightSwap]
 */
fun minArray(numbers: IntArray): Int {
    var left = 0
    var right = numbers.size - 1// 一定要前闭后闭
    while (left != right) {
        val mid = (left + right) / 2
        when {// 注意，mid元素与right元素比值，因为左子数组每个元素都>=右子数组的每个元素
            numbers[mid] > numbers[right] -> left = mid + 1
            numbers[mid] < numbers[right] -> right = mid
            else -> right--// 这里没法判断mid在左子数组还是右子数组，所以只能暴力--
        }
    }
    return numbers[left]
}