class Solution {
    fun isPalindrome(s: String): Boolean {
        var p1 = 0
        var p2 = s.length - 1

        while (p1 < p2) {
            if (!s[p1].isLetterOrDigit()) {
                p1++
            } else if (!s[p2].isLetterOrDigit()) {
                p2--
            } else if (!s[p1].equals(s[p2], ignoreCase=true)) {
                return false
            } else {
                p1++
                p2--
            }
        }

        return true
    }
}
