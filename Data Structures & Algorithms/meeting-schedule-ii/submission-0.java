/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.size() == 0) return 0;

        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        // 0, 5, 15
        // 10, 20, 40

        int rooms = 0;
        int endPtr = 0;

        for (int i = 0; i < n; i++) {
            if (start[i] < end[endPtr]) { // 0 < 10 -> rooms = 1;
            // 5 < 10 -> rooms = 2;
            // 15 < 10 -> endPtr = 1;
            // 
                rooms++;
            }
            else {
                endPtr++;
            }
        }
        return rooms;
    }
}
