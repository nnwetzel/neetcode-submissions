
class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();
        int longestLen = 0;

        int l = 0, maxFreq = 0;
        for (int r = 0; r < s.length(); r++) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            maxFreq = Math.max(maxFreq, count.get(s.charAt(r)));

            // while the amount of replacable character exceeds k
            // replacable characters are any character that is not the most frequent character in the window
            while ((r - l + 1) - maxFreq > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
            }
            longestLen = Math.max(longestLen, r - l + 1);
        }
        return longestLen;
    }
}
