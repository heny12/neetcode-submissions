class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        for (row in 0 until board.size) {
            for (col in 0 until board[0].size) {
                val visited = Array(board.size) { BooleanArray(board[0].size) {false} }
                val found = check(board, visited, word, row, col, 0)
                if (found) {
                    return true
                }
            }
        }

        // no word found
        return false
    }

    private fun check(board: Array<CharArray>, visited: Array<BooleanArray>, word: String, row: Int, col: Int, index: Int): Boolean {
        //word found
        if (index >= word.length) {
            return true
        }

        // out of bounds
        if (row < 0 || col < 0 || row >= board.size || col >= board[0].size) {
            return false
        }

        // visited
        if (visited[row][col]) {
            return false
        }

        // wrong letter
        if (board[row][col] != word[index]) {
            return false
        } else {
            // correct letter
            // check neighbors
            visited[row][col] = true
            val found = check(board, visited, word, row + 1, col, index + 1) ||
                check(board, visited, word, row - 1, col, index + 1) ||
                check(board, visited, word, row, col + 1, index + 1) ||
                check(board, visited, word, row, col - 1, index + 1)
            visited[row][col] = false
            return found
        }
    }
}
