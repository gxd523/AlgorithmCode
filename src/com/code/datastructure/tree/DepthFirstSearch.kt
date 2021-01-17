package com.code.datastructure.tree

/**
 * 前序遍历：根、左、右
 */
fun preorderTraversal(list: MutableList<Int>, node: TreeNode?) {
    if (node == null) {
        return
    }
    list.add(node.value)
    preorderTraversal(list, node.left)
    preorderTraversal(list, node.right)
}

/**
 * 中序遍历：左、根、右
 */
fun inorderTraversal(list: MutableList<Int>, node: TreeNode?) {
    if (node == null) {
        return
    }
    inorderTraversal(list, node.left)
    list.add(node.value)
    inorderTraversal(list, node.right)
}

/**
 * 后序遍历：左、右、根
 */
fun postorderTraversal(list: MutableList<Int>, node: TreeNode?) {
    if (node == null) {
        return
    }
    postorderTraversal(list, node.left)
    postorderTraversal(list, node.right)
    list.add(node.value)
}

fun main() {
    listOf(
        ::preorderTraversal,
        ::inorderTraversal,
        ::postorderTraversal,
    ).let { list ->
        list.map {
            Triple(
                it,
                createTree(intArrayOf(0, 1, 2, 3, 4, 5, 6)),
                Regex("""fun ([a-zA-Z]+)\(""")
            )
        }
    }.asSequence()
        .forEach { triple ->
            val (traversalFunc, root, regex) = triple
            val list = emptyList<Int>().toMutableList()
            traversalFunc.invoke(list, root)
            val toString = traversalFunc.toString()
            "${toString.let { regex.findAll(it).asSequence().last().groupValues.last() }}...$list".let(::println)
        }
}