class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = mutableMapOf<Int,Int>()
        nums.forEach {
            map[it] = map.getOrPut(it) { 0 } + 1
        }
        val ordered = map.map { (k,v) ->
            Pair(k,v)
        }.sortedByDescending { 
            it.second
        }
        return ordered.take(k).map{it.first}.toIntArray()
        // val heap = PriorityQueue<Pair<Int,Int>>(compareByDescending({it.second}))
        // map.forEach { (k,v) ->
        //     heap.add(Pair(k, v))
        // }

        // val topK = mutableListOf<Int>()
        // var nums = k
        // while (nums > 0 && !heap.isEmpty()) {
        //     topK.add(heap.poll().first)
        //     nums--
        // }
        // return topK.toIntArray()
    }
}
