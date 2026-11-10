class TimeMap() {
    private val store = HashMap<String, MutableList<Pair<String, Int>>>()

    fun set(key: String, value: String, timestamp: Int) {
        store.computeIfAbsent(key) { mutableListOf() }.add(Pair(value, timestamp))
    }

    fun get(key: String, timestamp: Int): String {
        val list = store[key] ?: return ""

        var left = 0
        var right = list.size - 1
        var result = ""

        while (left <= right) {
            val mid = left + (right - left) / 2
            if (list[mid].second <= timestamp) {
                result = list[mid].first // Valid candidate; search right for a larger timestamp <= target
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return result
    }
}