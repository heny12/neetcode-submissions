/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        val pList = mutableListOf<TreeNode>()
        val qList = mutableListOf<TreeNode>()
        p?.let { pList.add(it) }
        q?.let { qList.add(it) }

        while (qList.size != 0 && pList.size != 0) {
            val pNode = pList.removeAt(0)
            val qNode = qList.removeAt(0)

            if (pNode.`val` != qNode.`val` ||
                pNode.left?.`val` != qNode.left?.`val`||
                pNode.right?.`val` != qNode.right?.`val`) {
                    return false
            }

            pNode.left?.let { pList.add(it) }
            pNode.right?.let { pList.add(it) }
            qNode.left?.let { qList.add(it) }
            qNode.right?.let { qList.add(it) }
        }

        return pList.size == qList.size
    }
}
