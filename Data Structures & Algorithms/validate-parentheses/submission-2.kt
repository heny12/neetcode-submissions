class Solution {

    val openingToClosing = mapOf('(' to ')', '[' to ']', '{' to '}')
    val closingToOpening = mapOf(')' to '(', ']' to '[', '}' to '{')

    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        s.toCharArray().forEach { c ->
            val last = stack.firstOrNull()
            // closing bracket
            if (closingToOpening.containsKey(c)) {
                // no opening bracket
                if (last == null || !openingToClosing.containsKey(stack.first())) {
                    return false
                // incompatible opening bracket
                } else if (last!! != closingToOpening[c]) {
                    return false
                // compatible opening bracket
                } else {
                    stack.removeFirst()
                }
            } else if (openingToClosing.containsKey(c)) {
                stack.addFirst(c)
            }
        }

        if (stack.isNotEmpty()) {
            return false
        } else {
            return true
        }

    }
}
