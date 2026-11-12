class Solution {

    private val directions = arrayOf(
        arrayOf(-1, 0),
        arrayOf(1, 0),
        arrayOf(0, 1),
        arrayOf(0, -1)
    )

    fun orangesRotting(grid: Array<IntArray>): Int {
        if (grid.isEmpty()) return -1

        var fresh = 0
        var time = 0
        val queue = ArrayDeque<Pair<Int, Int>>()
        val visited = Array(grid.size) { Array(grid[0].size) { false } }

        // 1. Set up initial state
        grid.forEachIndexed { row, values ->
            values.forEachIndexed { col, value ->
                if (value == 1) {
                    fresh++
                } else if (value == 2) {
                    visited[row][col] = true
                    queue.add(Pair(row, col))
                }
            }
        }

        // 2. Spread rot wave by wave
        while (queue.isNotEmpty() && fresh > 0) {
            time++
            val waveSize = queue.size // Snapshot current wave size
            for (i in 0 until waveSize) {
                val rot = queue.removeFirst()
                val row = rot.first
                val col = rot.second

                // Spread rot from the current rotten fruit to its valid fresh neighbors
                directions.forEach { dir ->
                    val newRow = row + dir[0]
                    val newCol = col + dir[1]

                    // Fixed bounds check + fresh check + unvisited check
                    if (newRow >= 0 && newCol >= 0 &&
                        newRow < grid.size && newCol < grid[0].size &&
                        grid[newRow][newCol] == 1 && !visited[newRow][newCol]
                    ) {
                        visited[newRow][newCol] = true
                        fresh--
                        queue.addLast(Pair(newRow, newCol))
                    }
                }
            }
        }

        return if (fresh > 0) -1 else time
    }
}