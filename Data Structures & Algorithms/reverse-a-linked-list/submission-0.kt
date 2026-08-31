/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var front = head
        while (head?.next != null) {
            val temp = head?.next
            head?.next = head?.next?.next
            temp?.next = front
            front = temp
        }

        return front
    }
}
