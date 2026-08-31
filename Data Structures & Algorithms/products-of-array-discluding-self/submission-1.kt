class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val products = IntArray(nums.size) { 1 }

        // left to right accumulating product
        var product = 1
        for (i in 0..(nums.size - 1)) {
            products[i] = product
            product *= nums[i]
        }


        // right to left accumulating product
        product = 1
        for (i in (nums.size - 1) downTo 0) {
            products[i] = products[i] * product
            product *= nums[i]
        }

        return products
    }
}
