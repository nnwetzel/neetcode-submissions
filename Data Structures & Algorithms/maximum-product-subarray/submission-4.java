class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int currMax = nums[0];
        int currMin = nums[0];
        int result = nums[0];

        for (int i = 1; i < n; i++) {
            int x = nums[i];

            if (x < 0) {
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }

            currMax = Math.max(x, currMax * x);
            currMin = Math.min(x, currMin * x);

            result = Math.max(result, currMax);
        }
        return result;
    }
}
