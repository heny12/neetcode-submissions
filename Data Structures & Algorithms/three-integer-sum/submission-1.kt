class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val count = HashMap<Int, Int>()
        for (num in nums) {
            count[num] = count.getOrDefault(num, 0) + 1
        }

        val res = mutableListOf<List<Int>>()
        for (i in nums.indices) {
            count[nums[i]] = count[nums[i]]!! - 1
            if (i > 0 && nums[i] == nums[i - 1]) continue

            for (j in i + 1 until nums.size) {
                count[nums[j]] = count[nums[j]]!! - 1
                if (j > i + 1 && nums[j] == nums[j - 1]) continue

                val target = -(nums[i] + nums[j])
                if (count.getOrDefault(target, 0) > 0) {
                    res.add(listOf(nums[i], nums[j], target))
                }
            }

            for (j in i + 1 until nums.size) {
                count[nums[j]] = count[nums[j]]!! + 1
            }
        }

        return res
    }
}