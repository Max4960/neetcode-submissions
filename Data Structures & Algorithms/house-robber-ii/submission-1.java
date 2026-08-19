class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(calc(nums, 0, nums.length-2), calc(nums, 1, nums.length-1));
    }

    
    private int calc(int[] nums, int start, int end) {
        int r1 = 0;
        int r2 = 0;
        for (int i = start; i <= end; i++) {
            int temp = Math.max(nums[i]+r1, r2);
            r1 = r2;
            r2 = temp;
        }
        return r2;
    }
}
