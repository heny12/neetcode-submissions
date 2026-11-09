class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val merged = mutableListOf<IntArray>()
        val sorted = intervals.sortBy { it[0] }
        intervals.forEach { curr ->
            if (merged.isEmpty() || merged.last()[1] < curr[0]) {
                merged.add(curr)
            } else{
                // Merge
                merged.last()[1] = maxOf(merged.last()[1], curr[1])
            }
        }
        return merged.toTypedArray()
    }
}