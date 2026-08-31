class Solution {

    private val delimiter = "#"

    fun encode(strs: List<String>): String {
        var encoded = ""
        strs.forEach { str -> 
            encoded += str.length
            encoded += delimiter
            encoded += str
        }
        return encoded
    }

    fun decode(str: String): List<String> {
        var decode = str
        val decoded = mutableListOf<String>()
        while (decode.length > 0) {
            val i = decode.indexOf(delimiter)
            val length = decode.substring(0,i).toInt()
            decoded.add(decode.substring(i+1, i+1+length))
            decode = decode.substring(i+1+length, decode.length)
        }
        return decoded
    }
}
