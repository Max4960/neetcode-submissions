class Solution {
    public int uniquePaths(int m, int n) {
        return dfs(0,0,m,n);
    }

    private int dfs(int r, int c, int m, int n) {
        int rows = m - 1;
        int cols = n - 1;

        if (r == rows && c == cols) {
            return 1;
        }
        if (r >= rows + 1 || c >= cols + 1) { // out of bounds
            return 0;
        }
        
        return dfs(r, c + 1, m, n) + 
                dfs (r + 1, c, m, n); 
    }
}
