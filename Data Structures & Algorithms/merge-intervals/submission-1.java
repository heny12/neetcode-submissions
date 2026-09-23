class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int i = 0;
        while (i < intervals.length) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            int j = i + 1;
            while (j < intervals.length && intervals[j][0] <= end) {
                end = Math.max(end, intervals[j][1]);
                j++;
            }

            merged.add(new int[]{start, end});
            i = j; // Move directly to the first non-overlapping interval
        }

        return merged.toArray(new int[merged.size()][]);
    }
}