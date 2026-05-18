class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 1; j++) {
                int l = i;
                int r = i + j;
                while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                }
                l++;
                r--;
                if (r - l > end - start) {
                    start = l;
                    end = r;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
