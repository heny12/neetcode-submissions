class Solution {
    fun rob(nums: IntArray): Int {
        val memo = mutableMapOf<Int, Int>()
        return nums.mapIndexed { i, num -> explore(i, nums, memo) }.maxOrNull() ?: 0
    }

    private fun explore(i: Int, nums: IntArray, memo: MutableMap<Int, Int>): Int {
        if (!memo.containsKey(i)) {
            if (i >= nums.size) {
                memo[i] = 0
            } else {
                val skip = explore(i+1, nums, memo)
                val rob = nums[i] + explore(i+2, nums, memo)
                memo[i] = maxOf(skip, rob)
            }
        }

        return memo[i]!!
    }
}
