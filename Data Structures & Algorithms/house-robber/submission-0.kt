class Solution {
    fun rob(nums: IntArray): Int {
        val memo = mutableMapOf<Int, Int>()
        return nums.mapIndexed { i, num -> explore(i, nums, memo) }.maxOrNull() ?: 0
    }

    private fun explore(i: Int, nums: IntArray, memo: MutableMap<Int, Int>): Int {
        if (!memo.containsKey(i)) {
            if (i >= nums.size) {
                memo[i] = 0
            }

            var bestNext = 0
            for (j in (i+2) until nums.size) {
                bestNext = maxOf(bestNext, explore(j, nums, memo))
            }
            val sum = nums[i] + bestNext
            memo[i] = sum
        }

        return memo[i]!!
    }
}
