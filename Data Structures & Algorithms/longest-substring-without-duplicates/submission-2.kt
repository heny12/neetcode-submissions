class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val mp = HashMap<Char, Int>()
        var l = 0
        var res = 0

        for (r in s.indices) {
            if (s[r] in mp) {
                l = maxOf(mp[s[r]]!! + 1, l)
            }
            mp[s[r]] = r
            res = maxOf(res, r - l + 1)
        }
        return res
    }
}
