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
                v2[0]--;
                res += (char) (v2[1] + 'a');
                if (v2[0] >= 1) {
                    maxHeap.add(v2);
                }
            }
            v1[0]--;
            if (v1[0] >= 1) {
                maxHeap.add(v1);
            }
        }
        return res;
    }
}