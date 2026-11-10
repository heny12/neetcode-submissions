class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val stack = ArrayDeque<Pair<Int,Int>>()
        val queue = ArrayDeque<Int>()
        for (i in (temperatures.size-1) downTo 0) {
            val temp = temperatures[i]
            while (!stack.isEmpty() && stack.first().second <= temp) {
                stack.removeFirst()
            }
            if (stack.isEmpty()) {
                queue.addFirst(0)
            } else {
                val diff = stack.first().first - i
                queue.addFirst(diff)
            }
            stack.addFirst(Pair(i, temp))
        }
        return queue.toIntArray()
    }
}
