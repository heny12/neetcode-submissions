class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        return strs.toList().groupBy { it.toCharArray().sorted() }.values.toList()
    }
}
