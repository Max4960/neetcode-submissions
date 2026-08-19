class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return new int[0];
        }

        int[] out = new int[n];
        out[0] = 1;

        for (int i = 1; i < n; i++) {
            out[i] = out[i-1] * nums[i-1];
        }

        int right = 1;
        for (int i = n-1; i >= 0; i--) {
            out[i] *= right;
            right *= nums[i];
        }
        return out;
    }
}  
