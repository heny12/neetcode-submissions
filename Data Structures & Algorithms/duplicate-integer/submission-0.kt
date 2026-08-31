class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val counts = mutableMapOf<Int, Int>()
        nums.forEach { num ->
            if (counts.containsKey(num)) {
                return true
            } else {
                counts[num] = 1
            }
        }
        return false
    }
}
