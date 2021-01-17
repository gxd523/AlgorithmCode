package com.code.datastructure.tree

import java.util.*

/**
 * 剑指题：32.3
 * 从上往下打印每行，每行按照从左往右、从右往左交替打印
 */
fun levelOrder(root: TreeNode?): List<List<Int>> {
    val list = emptyList<MutableList<Int>>().toMutableList()
    if (root == null) {
        return list
    }
    val currentLayerNodeQueue = LinkedList<TreeNode>()
    currentLayerNodeQueue += root
    recurseLayer(list, currentLayerNodeQueue, 0)
    return list
}

fun recurseLayer(list: MutableList<MutableList<Int>>, currentLayerNodeQueue: LinkedList<TreeNode>, layer: Int) {
    if (currentLayerNodeQueue.isEmpty()) {
        return
    }
    val currentLayerValueList = emptyList<Int>().toMutableList()

    for (i in currentLayerNodeQueue.indices) {
        val node = currentLayerNodeQueue.poll()

        if (layer % 2 == 0) {
            currentLayerValueList += node.value
        } else {
            currentLayerValueList.add(0, node.value)
        }


        node.left?.let { currentLayerNodeQueue += it }
        node.right?.let { currentLayerNodeQueue += it }
    }
    list += currentLayerValueList
    recurseLayer(list, currentLayerNodeQueue, layer + 1)
}
