class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        List<int[]> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Value: " + entry.getValue() + ", Entry: " + entry.getKey());
            arr.add(new int[]{entry.getValue(), entry.getKey()});
        }

        arr.sort((a,b) -> Integer.compare(b[0], a[0]));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr.get(i)[1];
        }

        return result;
    }
}
