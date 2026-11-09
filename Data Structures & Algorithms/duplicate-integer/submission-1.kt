class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        return nums.groupBy { it }.values.any { it.size > 1 }
    }
}
