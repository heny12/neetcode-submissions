/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun canAttendMeetings(intervals: List<Interval>): Boolean {
        val sorted = intervals.sortedBy { it.start }

        println(sorted)

        sorted.forEachIndexed { i, interval ->
            val next = sorted.getOrNull(i+1)
            println("comparing " + interval.start + "," + interval.end + " to " + next?.start + "," + next?.end)
            if (next != null && interval.end > next.start) {
                return false
            }
        }

        return true
    }
}
