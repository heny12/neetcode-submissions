class Solution {

    private final val directions = arrayOf(
        arrayOf(1,0),
        arrayOf(-1,0),
        arrayOf(0,1),
        arrayOf(0,-1)
    )

    fun numIslands(grid: Array<CharArray>): Int {
        var islands = 0
        for (row in 0 until grid.size) {
            for (col in 0 until grid[0].size) {
                if (grid[row][col] == '1') {
                    islands++
                    explore(grid, row, col)
                }
            }
        }
        return islands
    }

    private fun explore(grid: Array<CharArray>, row: Int, col: Int) {
        if (row < 0 || col < 0 || row >= grid.size || col >= grid[0].size) {
            // out of bounds
            return
        }

        if (grid[row][col] != '1') {
            // not land
            return
        }

        grid[row][col] = '2' // Mark visited

        directions.forEach { direction ->
            // Visit all neighbors
            explore(grid, row + direction[0], col + direction[1])
        }
    }
}
