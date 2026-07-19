import java.util.*;

class Solution {

    static class Cell {
        int row, col, effort;

        Cell(int row, int col, int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
    }

    public int minimumEffortPath(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        // effort[r][c] = minimum possible maximum effort to reach (r, c)
        int[][] effort = new int[rows][cols];

        for (int[] row : effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Min-heap based on effort
        PriorityQueue<Cell> pq =
                new PriorityQueue<>((a, b) -> a.effort - b.effort);

        effort[0][0] = 0;
        pq.offer(new Cell(0, 0, 0));

        // Directions: up, down, left, right
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {

            Cell current = pq.poll();
            int r = current.row;
            int c = current.col;
            int currEffort = current.effort;

            // Reached destination
            if (r == rows - 1 && c == cols - 1) {
                return currEffort;
            }

            // Skip outdated entries
            if (currEffort > effort[r][c]) continue;

            // Explore all 4 directions
            for (int i = 0; i < 4; i++) {

                int nr = r + dr[i];
                int nc = c + dc[i];

                // Check boundaries
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {

                    int edgeCost = Math.abs(heights[r][c] - heights[nr][nc]);

                    // Path effort = max(current effort, new edge cost)
                    int newEffort = Math.max(currEffort, edgeCost);

                    // Relaxation step
                    if (newEffort < effort[nr][nc]) {
                        effort[nr][nc] = newEffort;
                        pq.offer(new Cell(nr, nc, newEffort));
                    }
                }
            }
        }

        return 0; // Only one cell case
    }
}