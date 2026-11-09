/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun canAttendMeetings(intervals: List<Interval>): Boolean {
        val sorted = intervals.sortedBy { it.start }
        for (i in 0 until (sorted.size - 1)) {
            if (sorted[i].end > sorted[i+1].start) return false
        }
        return true
    }
}
