class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.length == 0) {
            return 0
        }

        val chars = mutableMapOf<Char, Int>()
        var longest = 0
        var p1 = 0
        var p2 = 0

        while (p2 < s.length) {
            // increment letter count for expanded window
            chars[s[p2]] = chars.getOrDefault(s[p2], 0) + 1

            // collision, shrink window til no collision
            while (chars[s[p2]]!! > 1) {
                chars[s[p1]] = chars[s[p1]]!! - 1
                p1++
            }
            
            // continue expanding window
            p2++
            longest = maxOf(longest, p2-p1)
        }

        return longest
    }
}
