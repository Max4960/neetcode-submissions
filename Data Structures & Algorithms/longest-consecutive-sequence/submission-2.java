class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 0) {
            return 0;
        }
        int longest = 1;
        int current = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1] + 1) {
                current++;
            } else if (nums[i] == nums[i-1]) {
                continue;
            } else {
                current = 0;
            }
            if (current > longest) {
                longest = current;
            }
        }
        return longest;
    }
}
