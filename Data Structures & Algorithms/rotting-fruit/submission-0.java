class Solution {
    private final int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    Queue<int[]> q = new LinkedList<>();
    private int time = 0;
    private int fresh = 0;

    public int orangesRotting(int[][] grid) {
        if (grid.length == 0) {
            return -1;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    q.add(new int[]{r, c});
                }
                if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }
        bfs(grid);
        if (fresh != 0) {
            return -1;
        }
        return time;
    }

    private void bfs(int[][] grid) {
        while (!q.isEmpty()) {
            int size = q.size(); // oranges to process
            boolean rotted = false;
            for (int i = 0; i < size; i++) {
                int[] node = q.poll();
                int row = node[0];
                int col = node[1];
                grid[row][col] = 0;

                for (int[] dir : directions) {
                    int nr = row + dir[0];
                    int nc = col + dir[1];

                    if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        fresh--;
                        q.add(new int[]{nr, nc});
                        rotted = true;
                    }
                }
            }
            if (rotted) {
                time++;
            }
        }
    }
}
