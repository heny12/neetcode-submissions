/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var list: ListNode? = null
        var p: ListNode? = null
        var p1 = list1
        var p2 = list2

        if (p1 == null && p2 == null) {
            return null
        } else if (p1 == null) {
            return p2
        } else if (p2 == null) {
            return p1
        } else if (p1.`val` <= p2.`val`) {
            list = p1
            p = list
            val temp = p1.next
            list.next = null
            p1 = temp
        } else {
            list = p2
            p = list
            val temp = p2.next
            list.next = null
            p2 = temp
        }

        while (p1 != null || p2 != null) {
            if (p1 == null) {
                p!!.next = p2
                p2 = null
            } else if (p2 == null) {
                p!!.next = p1
                p1 = null
            } else if (p1.`val` <= p2.`val`) {
                p!!.next = p1
                p = p!!.next
                val temp = p!!.next
                p!!.next = null
                p1 = temp
            } else {
                p!!.next = p2
                p = p!!.next
                val temp = p!!.next
                p!!.next = null
                p2 = temp
            }
        }

        return list
    }
}
