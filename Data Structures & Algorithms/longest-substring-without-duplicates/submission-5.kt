class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val lastSeen = IntArray(128) { -1 }
        var longest = 0
        var p1 = 0

        for (p2 in s.indices) {
            val code = s[p2].code
            if (lastSeen[code] >= p1) {
                p1 = lastSeen[code] + 1
            }
            lastSeen[code] = p2
            longest = maxOf(longest, p2 - p1 + 1)
        }

        return longest
    }
}