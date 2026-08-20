class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();

        Arrays.sort(nums);

        for (int cur = 0; cur < nums.length; cur++) {
            int left = cur + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (nums[cur] + nums[left] + nums[right] == 0) {
                    sol.add(new ArrayList<>(Arrays.asList(nums[cur], nums[left], nums[right])));
                    break;
                } else if (nums[left] + nums[right] < cur) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return sol;
    }
}
