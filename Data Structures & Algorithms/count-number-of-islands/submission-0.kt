class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val visited = Array(grid.size) { BooleanArray(grid[0].size) { false }}
        var count = 0

        for (y in 0 until grid.size) {
            for (x in 0 until grid[0].size) {
                if (grid[y][x].toString() == "1" && !visited[y][x]) {
                    count++
                    search(y, x, grid, visited)
                }
            }
        }

        return count
    }

    private fun search(y: Int, x: Int, grid: Array<CharArray>, searched: Array<BooleanArray>) {
        if (y < 0 || x < 0 || y >= grid.size || x >= grid[0].size) {
            return
        }
        if (!searched[y][x] && grid[y][x].toString() == "1") {
            searched[y][x] = true
            search(y+1, x, grid, searched)
            search(y-1, x, grid, searched)
            search(y, x+1, grid, searched)
            search(y, x-1, grid, searched)
        }
    }
}
