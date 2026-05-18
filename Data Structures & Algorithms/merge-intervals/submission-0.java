class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();

        int[] curr = intervals[0];
        res.add(curr);

        for (int i = 1; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (start <= curr[1]) {
                curr[1] = Math.max(curr[1], end);
            }
            else {
                curr = intervals[i];
                res.add(curr);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
