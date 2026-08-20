class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] pair = new int[2];
        HashMap<Integer, Integer> numbers = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            numbers.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (numbers.containsKey(target - nums[i])) {
                pair[0] = i;
                pair[1] = numbers.get(target - nums[i]);
            }
        }
        if (pair[1] < pair[0]) {
            int temp = pair[1];
            pair[1] = pair[0];
            pair[0] = temp;
        }
        return pair;
    }
}
