class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val groupMap = mutableMapOf<Map<Char, Int>, List<String>>()

        strs.forEach { str ->
            // build character counts for each string
            val strMap = mutableMapOf<Char, Int>()
            str.forEach { c -> 
                strMap[c] = strMap.getOrDefault(c, 0) + 1
            }

            // group anagrams
            groupMap[strMap] = groupMap.getOrDefault(strMap, mutableListOf()) + str
        }

        return groupMap.values.toList()
    }
}
