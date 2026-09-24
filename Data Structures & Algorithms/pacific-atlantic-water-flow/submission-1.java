class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> coords = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return coords;
        }

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] canReachPacific = new boolean[rows][cols];
        boolean[][] canReachAtlantic = new boolean[rows][cols];

        // 1. Traverse from horizontal borders (top Pacific, bottom Atlantic)
        for (int c = 0; c < cols; c++) {
            dfs(heights, canReachPacific, 0, c);
            dfs(heights, canReachAtlantic, rows - 1, c);
        }

        // 2. Traverse from vertical borders (left Pacific, right Atlantic)
        for (int r = 0; r < rows; r++) {
            dfs(heights, canReachPacific, r, 0);
            dfs(heights, canReachAtlantic, r, cols - 1);
        }

        // 3. Any cell reached by both oceans is part of the result
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (canReachPacific[r][c] && canReachAtlantic[r][c]) {
                    coords.add(List.of(r, c));
                }
            }
        }

        return coords;
    }

    private void dfs(int[][] heights, boolean[][] reachable, int row, int col) {
        reachable[row][col] = true;

        for (int[] dir : DIRECTIONS) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];

            // In bounds, unvisited, and water can flow downhill (meaning we move uphill or flat)
            if (nextRow >= 0 && nextRow < heights.length &&
                nextCol >= 0 && nextCol < heights[0].length &&
                !reachable[nextRow][nextCol] &&
                heights[nextRow][nextCol] >= heights[row][col]) {
                
                dfs(heights, reachable, nextRow, nextCol);
            }
        }
    }
}