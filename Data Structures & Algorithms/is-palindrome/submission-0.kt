class Solution {
    fun isPalindrome(s: String): Boolean {
        val asciiString = s.filter { it.isLetterOrDigit() }
        println(asciiString)
        var p1 = 0
        var p2 = asciiString.length - 1

        while (p2 > p1) {
            if (!asciiString[p1].equals(asciiString[p2], ignoreCase = true) ) {
                println("" + asciiString[p1] + " != " + asciiString[p2])
                return false
            }

            p1++
            p2--
        }

        return true
    }
}
