/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {

    fun minMeetingRooms(intervals: List<Interval>): Int {
        val ends = PriorityQueue<Int>(compareBy{ it }) 
        var max = 0
        intervals.sortedBy { it.start }.forEach { interval ->
            // remove all non-overlapping meetings
            while (!ends.isEmpty() && ends.peek() <= interval.start) {
                ends.poll()
            }

            ends.add(interval.end)
            max = maxOf(max, ends.size)
        }

        return max
    }
}
