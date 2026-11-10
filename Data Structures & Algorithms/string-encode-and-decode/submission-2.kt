class Solution {

    fun encode(strs: List<String>): String {
        val sb = StringBuilder()
        strs.forEach { sb.append(it.length.toString() + "#" + it) }
        return sb.toString()
    }

    fun decode(str: String): List<String> {
        print(str)
        val words = mutableListOf<String>()
        var i = 0
        var length = 0
        var buildingLength = true
        var sb = StringBuilder()
        while(i < str.length) {
            if (buildingLength && str[i] == '#') {
                buildingLength = false
            } else if (buildingLength) {
                length = (length * 10) + str[i].digitToInt()
            } else {
                sb.append(str[i])
                length--
            }
            if (!buildingLength && length == 0) {
                buildingLength = true
                words.add(sb.toString())
                sb.clear()
            }
            i++
        }
        return words
    }
}
