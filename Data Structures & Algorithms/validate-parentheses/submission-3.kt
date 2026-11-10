class Solution {
    private val closeToOpen = mapOf(
        ')' to '(',
        ']' to '[',
        '}' to '{'
    )

    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()

        for (c in s) {
            val matchingOpen = closeToOpen[c]
            if (matchingOpen != null) {
                // c is a closing bracket: ensure stack isn't empty and top matches
                if (stack.isEmpty() || stack.removeFirst() != matchingOpen) {
                    return false
                }
            } else {
                // c is an opening bracket
                stack.addFirst(c)
            }
        }

        return stack.isEmpty()
    }
}