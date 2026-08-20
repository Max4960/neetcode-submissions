class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();

        Arrays.sort(nums);

        for (int cur = 0; cur < nums.length-2; cur++) {
// improvement
            if (cur > 0 && nums[cur] == nums[cur-1]) continue;

            int left = cur + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (nums[cur] + nums[left] + nums[right] == 0) {
                    //if (!sol.contains(Arrays.asList(nums[cur], nums[left], nums[right]))) {
                        sol.add(new ArrayList<>(Arrays.asList(nums[cur], nums[left], nums[right])));
                    //}
                    left++; right--;
                    // improvement: skip duplicates
                    while (left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right++;
                    }
                } else if (nums[left] + nums[right] + nums[cur] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return sol;
    }
}
