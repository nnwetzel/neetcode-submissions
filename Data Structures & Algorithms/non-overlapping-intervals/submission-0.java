class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) return 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int removals = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (start < prevEnd) {
                removals++;
            }
            else {
                prevEnd = end;
            }
        }
        return removals;
    }
}
