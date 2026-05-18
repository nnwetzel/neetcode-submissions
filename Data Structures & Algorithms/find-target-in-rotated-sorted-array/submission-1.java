class Solution {
    public int search(int[] nums, int target) {
        // int index = -1, l = 0, r = nums.length - 1;
        // while(l <= r) {
        //     int m = l + (r - l) / 2;

        //     if (nums[m] == target) {
        //         return mid;
        //     }
        //     // 3 4 5 6 1 2 3
        //     if (nums[l] <= nums[mid]) {
        //         if (target > nums[m] || target < nums[l]) {

        //         }
        //     }
        // }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return i;
        }
        return -1;
        
    }
}
