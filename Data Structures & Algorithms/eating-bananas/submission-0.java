class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }
        int i = 1;
        int j = max;

        while (i < j) {
            int k = i + (j-i) / 2; 
            int time = 0;
            for (int x = 0; x < piles.length; x++) {
                if (piles[x] <= k) time++;
                else time += (piles[x]+k-1)/k;
            }

            if (time > h) {
                i = k + 1;
            } else {
                j = k;
            }
        }

        return i;
    }
}
