class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> newIntervals = new ArrayList<int[]>();
        boolean merging = false;
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if ((newInterval[0] >= interval[0] && newInterval[0] <= interval[1]) || (interval[0] <= newInterval[1] && interval[0] >= newInterval[0])) {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            } else {
                newIntervals.add(interval);
            }
        }
        newIntervals.add(newInterval);
        newIntervals.sort((a, b) -> Integer.compare(a[0], b[0]));
        return newIntervals.toArray(new int[newIntervals.size()][]);
    }
}
