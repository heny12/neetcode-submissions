/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        return validNode(root, null, null)
    }

    private fun validNode(node: TreeNode?, min: Int?, max: Int?): Boolean {
        if (node == null) {
            return true
        }

        if (min != null && node.`val` <= min) {
            return false
        }

        if (max != null && node.`val` >= max) {
            return false
        }

        return validNode(node?.left, min, node.`val`) && validNode(node?.right, node.`val`, max)
    }
}
