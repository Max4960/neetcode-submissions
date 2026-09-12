class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            seen.put(nums[i], i);
        }

        for (int j = 0; j < nums.length; j++) {
            if (seen.containsKey(target - nums[j])) {
                int index = seen.get(target - nums[j]);

                if (index == j) continue;
                if (index > j) return new int[]{j, index};
                if (index < j) return new int[]{index, j};
            }
        }
        return null;
    }
}
