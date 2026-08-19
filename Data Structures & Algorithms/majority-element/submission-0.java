class Solution {
    public int majorityElement(int[] nums) {
        double length = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        //System.out.println(n);
        for (int n : nums) {
            if (map.containsKey(n)) {

                map.put(n, map.get(n)+1);
            } else {
                map.put(n, 1);
            }
            if (map.get(n) > Math.floor(length/2)) {
                return n;
            }
        }
        return -1;
    }
}