class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // 2^(nums.length) subsets
        List<List<Integer>> solutions = new ArrayList<>();
        solutions.add(new ArrayList<>());

        for (int num : nums) {
            int size = solutions.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSubset = new ArrayList<>(solutions.get(i));
                newSubset.add(num);
                solutions.add(newSubset);
            }
        }
        return solutions;
    }
}
