class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        // iterate over all grid spaces
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {

                // get area of island, dfs traversal
                int area = getIslandArea(grid, row, col);

                // set max area to this island if larger than current max size
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    private int getIslandArea(int[][] grid, int row, int col) {
        // return if out of bounds
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
            return 0;
        }

        // return if not land
        if (grid[row][col] == 0) {
            return 0;
        }

        // set land to explored
        // do not revisit
        grid[row][col] = 0;

        // return sum of this land and all connected land
        return 1 + getIslandArea(grid, row + 1, col) + getIslandArea(grid, row - 1, col) + getIslandArea(grid, row, col + 1) + getIslandArea(grid, row, col - 1);
    }
}
