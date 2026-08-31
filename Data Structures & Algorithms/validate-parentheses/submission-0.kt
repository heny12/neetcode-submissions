class Solution {

    private val openChar = setOf('[', '{', '(')
    private val closeChars = mapOf(
        ']' to '[',
        '}' to '{',
        ')' to '('
    )

    fun isValid(s: String): Boolean {
        var valid = true
        var stack = mutableListOf<Char>()
        s.forEach { c ->
            if (openChar.contains(c)) {
                stack.add(c)
            } else if (closeChars.keys.contains(c)) {
                if (stack.size == 0) {
                    return false
                }
                val lastOpen = stack[stack.size - 1]
                stack.removeAt(stack.size - 1)
                if (closeChars[c] != lastOpen) {
                    return false
                }
            }
        }
        if (stack.size > 0) {
            return false
        } else {
            return true
        }
    }
}
