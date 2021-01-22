package com.code.algorithm.dynamicprogram

/**
 * 剑指题：42
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。
 * 求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 *
 * 动态规划
 */
fun maxSubArray(array: IntArray): Int {
    var preSub = array[0]
    var max = array[0]
    for (i in 1 until array.size) {
        var cur = array[i]

        if (preSub > 0) cur += preSub// 如果前面的子串>0就和当前值连起来，组成新的子串，否则断开，以当前值作为新子串的开始

        preSub = cur// 当前子串是下一次遍历的前子串

        if (cur > max) max = cur
    }
    return max
}

/**
 * 更进一步，将i - 1的array位置存放前子串的值
 */
fun maxSubArray1(array: IntArray): Int {
    var max = array[0]
    for (i in 1 until array.size) {
        if (array[i - 1] > 0) array[i] += array[i - 1]// 如果前面的子串>0就和当前值连起来，组成新的子串，否则断开，以当前值作为新子串的开始

        if (array[i] > max) max = array[i]
    }
    return max
}