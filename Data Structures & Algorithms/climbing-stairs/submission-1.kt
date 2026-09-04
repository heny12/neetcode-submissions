class Solution {
    fun climbStairs(n: Int): Int {
        var cache = IntArray(n+1){-1}
        fun dfs(i: Int): Int {
            if (i >= n) return if (i == n) 1 else 0
            if (cache[i] != -1) return cache[i]
            cache[i] = dfs(i + 1) + dfs(i + 2)
            return cache[i]
        }
        return dfs(0)
    }
}
