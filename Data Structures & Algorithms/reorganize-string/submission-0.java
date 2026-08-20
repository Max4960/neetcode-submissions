class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> b[0] - a[0]
        );

        // check if possible + populate heap
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > (s.length() + 1) /  2) {
                return "";
            } else if (freq[i] > 0) {
                maxHeap.add(new int[]{freq[i], i});
            }
        }

        String res = "";
        while (!maxHeap.isEmpty()) {
            int[] v1 = maxHeap.poll();
            int[] v2;
            if (maxHeap.isEmpty()) {
                v2 = null;
            } else {
                v2 = maxHeap.poll();
            }

            res += (char) (v1[1] + 'a');

            if (v2 != null) {
                res += (char) (v2[1] + 'a');
                if (v2[0] >= 2) {
                    maxHeap.add(new int[]{v2[0] - 1, v2[1]});
                }
            }
            if (v1[0] >= 2) {
                maxHeap.add(new int[]{v1[0] - 1, v1[1]});
            }
        }
        return res;
    }
}