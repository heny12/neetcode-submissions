class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val startOfSequence = mutableMapOf<Int, Boolean>()

        // Track each value in array
        nums.forEach {
            startOfSequence[it] = true
        }

        // Mark start of sequences
        nums.forEach {
            if (startOfSequence.containsKey(it - 1)) {
                startOfSequence[it] = false
            }
        }

        // Calculate length of each sequence
        var maxSequence = 0
        startOfSequence.keys.forEach {
            if (startOfSequence[it]!! == true) {
                var sequence = 0
                var sequenceValue = it
                while (startOfSequence.containsKey(sequenceValue)) {
                    sequence++
                    sequenceValue++
                }
                if (sequence > maxSequence) {
                    maxSequence = sequence
                }
            }
        }

        return maxSequence
    }
}
