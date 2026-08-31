class Solution {
    fun maxArea(heights: IntArray): Int {
        var max = 0

        var p1 = 0
        var p2 = heights.size - 1

        while (p1 < p2) {
            val height = minOf(heights[p1], heights[p2])
            val width = p2 - p1
            val sum = width * height

            max = maxOf(sum, max)

            if (heights[p1] < heights[p2]) {
                p1++
            } else {
                p2--
            }
        }

        return max
    }
}
