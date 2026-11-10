class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        // error case - empty String
        if (s.length == 0) return 0
        var longest = 0
        // set up 2 pointers
        var lo = 0
        var hi = 0
        // track letter counts - mutable hash map
        val counts = mutableMapOf<Char,Int>()
        s.forEach { counts[it] = 0 }
        // expand window - hi++
        while (hi < s.length) {
            // if letter count increases to 2, shrink window til 1 - lo++
            counts[s[hi]] = counts[s[hi]]!!+1
            while (counts[s[hi]]!! > 1) {
                counts[s[lo]] = counts[s[lo]]!!-1
                lo++
            }
            hi++

            // update longest
            longest = maxOf(longest, hi-lo)
        }
        return longest
    }
}
