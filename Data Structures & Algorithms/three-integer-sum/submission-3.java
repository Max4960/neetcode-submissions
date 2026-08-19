class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();

        Arrays.sort(nums);

        for (int cur = 0; cur < nums.length; cur++) {
            int left = cur + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (nums[cur] + nums[left] + nums[right] == 0) {
                    if (!sol.contains(Arrays.asList(nums[cur], nums[left], nums[right]))) {
                        sol.add(new ArrayList<>(Arrays.asList(nums[cur], nums[left], nums[right])));
                    }
                    left++; right--;
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
