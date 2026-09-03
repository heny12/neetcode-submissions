/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        return if (root == null) {
            0
        } else {
            val leftDepth = maxDepth(root.left)
            val rightDepth = maxDepth(root.right)
            1 + maxOf(leftDepth, rightDepth)
        }
    }
}
