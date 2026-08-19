class Solution {
    public int rob(int[] nums) {
        int r1 = 0;
        int r2 = 0;
        for (int num : nums) {
            int temp = Math.max(num+r1, r2);
            r1 = r2;
            r2 = temp;
        }
        return r2;
    }
}
