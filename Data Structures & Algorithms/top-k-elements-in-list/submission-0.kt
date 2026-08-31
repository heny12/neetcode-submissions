class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val numCounts = mutableMapOf<Int, Int>()
        nums.forEach { num ->
            numCounts[num] = numCounts.getOrDefault(num, 0) + 1
        }

        val freqValues = mutableMapOf<Int, List<Int>>()
        numCounts.forEach { (num, freq) ->
            freqValues[freq] = freqValues.getOrDefault(freq, mutableListOf()) + num
        }

        val nums = mutableListOf<Int>()
        val freqsDesc = freqValues.keys.sortedDescending()
        var count = k
        freqsDesc.forEach { freq ->
            if (count > 0) {
                if (count > freqValues[freq]!!.size) {
                    nums.addAll(freqValues[freq]!!)
                    count -= freqValues[freq]!!.size
                } else {
                    nums.addAll(freqValues[freq]!!.take(count))
                    count = 0
                }
            }
        }

        return nums.toIntArray()
    }
}
