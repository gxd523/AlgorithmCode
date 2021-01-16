package com.code.datastructure.tree

/**
 * 广度优先遍历
 */
fun breadthTraversal(list: MutableList<Int>, currentLayerNodeList: List<TreeNode>) {
    if (currentLayerNodeList.isEmpty()) {
        return
    }
    val nextLayerNodeList = emptyList<TreeNode>().toMutableList()// 把下一层的节点存入集合

    for (i in currentLayerNodeList.indices) {// 遍历当前层的节点，值存入list，左右子节点顺序存入下一层节点集合
        val node = currentLayerNodeList[i]
        list.add(node.value)

        node.left?.let { left ->
            nextLayerNodeList.add(left)
        }
        node.right?.let { right ->
            nextLayerNodeList.add(right)
        }
    }
    breadthTraversal(list, nextLayerNodeList)
}

fun main() {
    emptyList<Int>()
        .toMutableList()
        .also {
            val root = createTree(intArrayOf(0, 1, 2, 3, 4, 5, 6))
            breadthTraversal(it, listOf(root))
        }
        .let(::println)
}