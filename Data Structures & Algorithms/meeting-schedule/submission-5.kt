/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun canAttendMeetings(intervals: List<Interval>): Boolean {
        val sorted = intervals.sortedBy { it.start }

        sorted.forEachIndexed { i, interval ->
            val next = sorted.getOrNull(i+1)
            if (next != null && interval.end > next.start) {
                return false
            }
        }

        return true
    }
}
