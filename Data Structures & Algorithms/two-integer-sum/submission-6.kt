class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
      val iNum = mutableMapOf<Int, List<Int>>()
      nums.forEachIndexed { i, num ->
        iNum[num] = iNum.getOrDefault(num, mutableListOf()) + i
      }

      val sorted = nums.sorted()
      var p1 = 0
      var p2 = sorted.size -1

      while (sorted[p2] + sorted[p1] != target) {
        val diff = (sorted[p2] + sorted[p1]) - target
        if (diff > 0) {
          p2--
        } else {
          p1++
        }
      }

      val iLo = iNum[sorted[p1]]!!.min()
      val iHi = iNum[sorted[p2]]!!.max()
      return intArrayOf(
        minOf(iLo, iHi),
        maxOf(iLo, iHi)
      )
    }
}
