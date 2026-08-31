class Solution {
    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0
        var low = prices[0]
        
        prices.forEachIndexed { i, price ->
            low = minOf(price, low)
            val profit = price - low
            maxProfit = maxOf(maxProfit, profit)
        }

        return maxOf(0, maxProfit)
    }
}
