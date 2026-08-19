class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> numset = new HashSet<>();

        for (int num : nums) {
            if (numset.contains(num)) return num;
            else numset.add(num);
        }
        return 0;
    }
}
