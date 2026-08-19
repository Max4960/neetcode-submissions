class Solution {
    private final int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    private int maxArea = 0;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;

        int islands = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    bfs(grid, r, c);
                    islands++;
                }
            }
        }
        return maxArea;
    }

    private void bfs(int[][] grid, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        grid[r][c] = 0; // mark this first node as visited
        q.add(new int[]{r, c});
        int area = 0;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];
            area++;

            for (int[] dir : directions) {
                int nr = row + dir[0];
                int nc = col + dir[1];

                if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length // check its in bounds
                    && grid[nr][nc] == 1) { // check if its an island
                    q.add(new int[]{nr, nc});
                    grid[nr][nc] = 0;
                }
            }
            if (area > maxArea) {
                maxArea = area;
            }
        }
    }
}
