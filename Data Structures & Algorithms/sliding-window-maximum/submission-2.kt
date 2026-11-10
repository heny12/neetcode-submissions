class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        if (nums.size < k) return intArrayOf()

        val heap = PriorityQueue<Pair<Int, Int>>(compareByDescending { it.second })
        val maxes = mutableListOf<Int>()

        var p = 0
        while (p < nums.size) {
            heap.add(Pair(p, nums[p]))
            if (p >= k - 1) {
                while (!heap.isEmpty() && heap.peek().first <= (p - k)) {
                    heap.poll()
                }
                maxes.add(heap.peek().second)
            }
            p++
        }

        return maxes.toIntArray()
    }
}
