class Solution {

    private static final int[][] directions = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public int orangesRotting(int[][] grid) {
        // empty grid check
        if (grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        // queue to track the spread of rot
        Queue<int[]> rottingQueue = new LinkedList<int[]>();

        // fill initial rot queue
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (isRotting(grid, row, col)) {
                    // add location and time of rot
                    rottingQueue.offer(new int[]{row, col, 0});
                }
            }
        }

        // System.out.println("Initial queue size - " + rottingQueue.size());

        // track minutes to spread all rot
        int minutes = 0;

        // continue spreading rot until cannot anymore
        while (!rottingQueue.isEmpty()) {
            int[] locationTime = rottingQueue.poll();
            int row = locationTime[0];
            int col = locationTime[1];
            int minute = locationTime[2];

            // check all neighbors of rotting fruit
            // spread rot if neighbor is fresh
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                int newTime = minute + 1;
                if (isFresh(grid, newRow, newCol)) {
                    grid[newRow][newCol] = 2;
                    // System.out.println("Adding fresh fruit to rot queue + " + newRow + "," + newCol + " time - " + newTime);
                    rottingQueue.offer(new int[]{newRow, newCol, newTime});

                    // track max time
                    if (newTime > minutes) {
                        minutes = newTime;
                    }
                }
            }
        }

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (isFresh(grid, row, col)) {
                    return -1;
                }
            }
        }
        
        return minutes;
    }

    private boolean isRotting(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
            return false;
        } else {
            return grid[row][col] == 2;
        }
    }

    private boolean isFresh(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
            return false;
        } else {
            return grid[row][col] == 1;
        }
    }
}
