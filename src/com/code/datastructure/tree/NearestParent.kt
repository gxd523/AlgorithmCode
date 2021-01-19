package com.code.datastructure.tree

/**
 * 剑指题：68.1
 * 找到二叉搜索树中，2个节点的最近父节点
 * 利用二叉搜索树左子树比右子树小，且没有重复元素的特点
 * 如果p、q分别分散在左右子树中，那么共同最近父节点一定是当前节点
 */
fun nearestParentSearchTree(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode? {
    var parent: TreeNode? = root
    while (parent != null) {
        parent = when {
            p.value > parent.value && q.value > parent.value -> parent.right// parent节点如果比p、q节点都小，说明p、q的直接父节点在当前parent的右边
            p.value < parent.value && q.value < parent.value -> parent.left// parent节点如果比p、q节点都大，说明p、q的直接父节点在当前parent的左边
            else -> break// 否则parent节点在p、q之间，那么p、q的直接父节点就是当前parent，牛逼
        }
    }
    return parent
}

/**
 * 剑指题：68.2
 * 找到二叉树中，2个节点的最近父节点
 * 注意不是二叉搜索树了
 * 采用后序遍历
 * 如果p、q分别分散在左右子树中，那么共同最近父节点一定是当前节点
 * 如果p、q在一边，那么先遍历到的就是另一个的父节点，同时自己是自己的父节点
 */
fun nearestParent(root: TreeNode?, p: TreeNode, q: TreeNode): TreeNode? {
    if (root == null) return null

    if (root == p || root == q) return root// 如果遍历到了p或者q就返回

    val left = nearestParent(root.left, p, q)
    val right = nearestParent(root.right, p, q)
    if (left != null && right != null) {
        return root// 如果left、right都不为空，说明p、q分散在两边，那么父元素就一定是根元素
    } else if (left != null && right == null) {
        return left
    } else if (right != null && left == null) {
        return right// 如果一边p、q都没遍历到，则p、q一定在另一边，而另一边先遍历到的，就是父元素(注意：p、q的父元素也可以是自己)
    }
    return null
}