class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.isEmpty()) return arrayOf()

        val sorted = intervals.sortedBy { it[0] }
        val newIntervals = mutableListOf<IntArray>()
        var interval: IntArray? = null

        sorted.forEachIndexed { i, v ->
            if (interval == null) {
                interval = v
            } else if (v[0] <= interval[1]) {
                // Merge
                interval[1] = maxOf(v[1], interval[1])
            } else {
                // Start new interval
                newIntervals.add(interval.copyOf())
                interval = v.copyOf()
            }
        }

        if (interval != null) {
            newIntervals.add(interval.copyOf())
        }

        return newIntervals.toTypedArray()
    }
}
