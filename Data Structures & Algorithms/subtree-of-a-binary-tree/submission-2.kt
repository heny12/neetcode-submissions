/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null) return false
        return subtreeMatch(root, subRoot) || isSubtree(root?.left, subRoot) || isSubtree(root?.right, subRoot)
    }

    private fun subtreeMatch(tree: TreeNode?, tree2: TreeNode?): Boolean {
        if (tree == null && tree2 == null) return true
        if (tree == null || tree2 == null || tree.`val` != tree2.`val`) return false
        return subtreeMatch(tree.left, tree2.left) && subtreeMatch(tree.right, tree2.right)
    }
}
