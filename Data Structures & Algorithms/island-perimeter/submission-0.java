class Solution {
    private int[][] grid;
    Set<String> visited = new HashSet<>();

    public int islandPerimeter(int[][] grid) {
        this.grid = grid;
        int rows = grid.length; int cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    return dfs(r,c);
                }
            }
        }
        return 0;
    }

    private int dfs(int r, int c) {
        // hit border or water
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0) {
            return 1;
        }
        String key = r + "," + c;
        if (visited.contains(key)) {
            return 0;
        }

        visited.add(key);

        return dfs(r+1, c) + dfs(r-1, c) + dfs (r, c+1) + dfs(r, c-1);
    }
}