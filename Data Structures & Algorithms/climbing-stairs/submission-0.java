class Solution {
    public int climbStairs(int n) {
        if (n == 0) {
            return 1; // one valid way
        }
        if (n < 0) {
            return 0; // overshot
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }
}
