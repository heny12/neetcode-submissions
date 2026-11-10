class TimeMap() {

    private val map: MutableMap<String, MutableList<Pair<Int, String>>> = mutableMapOf()

    fun set(key: String, value: String, timestamp: Int) {
        map.computeIfAbsent(key) { mutableListOf() }.add(Pair(timestamp, value))
    }

    fun get(key: String, timestamp: Int): String {
        val vals = map[key] ?: return ""

        var lo = 0
        var hi = vals.size - 1
        var result = ""

        // Changed from (lo < hi) to (lo <= hi)
        while (lo <= hi) {
            val mid = lo + (hi - lo) / 2
            if (vals[mid].first <= timestamp) {
                result = vals[mid].second
                lo = mid + 1
            } else {
                hi = mid - 1
            }
        }

        return result
    }
}