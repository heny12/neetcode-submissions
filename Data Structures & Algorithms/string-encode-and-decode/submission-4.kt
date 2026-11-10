class Solution {
    fun encode(strs: List<String>): String {
        val sb = StringBuilder()
        for (s in strs) {
            sb.append(s.length).append('#').append(s)
        }
        return sb.toString()
    }

    fun decode(str: String): List<String> {
        val words = mutableListOf<String>()
        var i = 0
        while (i < str.length) {
            val delimiterIndex = str.indexOf('#', i)
            val length = str.substring(i, delimiterIndex).toInt()
            
            val start = delimiterIndex + 1
            val end = start + length
            words.add(str.substring(start, end))
            
            i = end
        }
        return words
    }
}