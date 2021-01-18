package com.code.datastructure.tree

import java.util.*

/**
 * 剑指题：37
 * 可以按照BFS序列化二叉树
 * 非完全二叉树，序列化结果中，叶子节点的没有子节点要用null占位
 */
fun serializeTree(root: TreeNode?): Array<Int?> {
    val list = emptyList<Int?>().toMutableList()
    val queue = LinkedList<TreeNode?>()
    queue += root
    while (queue.isNotEmpty()) {
        val node = queue.poll()
        if (node == null) {
            list += null
        } else {
            list += node.value
            queue += node.left
            queue += node.right
        }
    }
    return list.dropLastWhile { it == null }.toTypedArray()// 最后丢弃了末尾的null节点
}

/**
 * 剑指题：37
 * 遍历集合
 * 元素不为null就创建节点，并添加到父节点，以及加入队列
 * 当前节点添加了左右子节点后出队
 */
fun deserialize(array: Array<Int?>): TreeNode? {
    val rootValue = array[0] ?: return null
    val root = TreeNode(rootValue)

    val queue = LinkedList<TreeNode>()
    queue += root

    var i = 1
    while (queue.isNotEmpty() && i < array.size) {// 注意数组越界
        val parent = queue.poll()

        array[i++]?.let { leftValue ->// 不为空的元素才创建节点
            TreeNode(leftValue).let { leftNode ->
                parent.left = leftNode// 添加到父节点上
                queue += leftNode// 添加到队列，下次循环作为父节点
            }
        }

        array[i++]?.let { rightValue ->
            TreeNode(rightValue).let { rightNode ->
                parent.right = rightNode
                queue += rightNode
            }
        }
    }
    return root
}

fun main() {
    arrayOf(1, null, 2, null, 3)
        .let(::deserialize)
        .let(::serializeTree)
        .let(::println)
}