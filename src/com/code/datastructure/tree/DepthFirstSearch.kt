package com.code.datastructure.tree

/**
 * 前序遍历：根、左、右
 */
fun preorderDfs(list: MutableList<Int>, node: TreeNode?) {
    if (node == null) {
        return
    }
    list += node.value
    preorderDfs(list, node.left)
    preorderDfs(list, node.right)
}

/**
 * 中序遍历：左、根、右
 */
fun inorderDfs(list: MutableList<Int>, node: TreeNode?) {
    if (node == null) {
        return
    }
    inorderDfs(list, node.left)
    list += node.value
    inorderDfs(list, node.right)
}

/**
 * 后序遍历：左、右、根
 */
fun postorderDfs(list: MutableList<Int>, node: TreeNode?) {
    if (node == null) {
        return
    }
    postorderDfs(list, node.left)
    postorderDfs(list, node.right)
    list += node.value
}

fun main() {
    listOf(
        ::preorderDfs,
        ::inorderDfs,
        ::postorderDfs,
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