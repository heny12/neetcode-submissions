class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }

        return getCharCounts(s) == getCharCounts(t)
    }

    private fun getCharCounts(s: String): Map<Char, Int> {
         val counts = mutableMapOf<Char, Int>()
         s.forEach {
            counts[it] = counts.getOrDefault(it, 0) + 1
         }
         return counts
    }
}
