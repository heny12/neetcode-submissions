class TimeMap() {

    val map = mutableMapOf<String,MutableMap<Int,String>>()

    fun set(key: String, value: String, timestamp: Int) {
        map.putIfAbsent(key, mutableMapOf())
        map[key]!![timestamp] = value
    }

    fun get(key: String, timestamp: Int): String {
        map.putIfAbsent(key, mutableMapOf())
        //TODO optimize
        var maxTs: Int? = null
        map[key]!!.forEach { (ts,_) ->
            if ((ts <= timestamp) && (maxTs == null || ts > maxTs)) {
                maxTs = ts
            }
        }
        return if (maxTs == null) {
            ""
        } else {
            map[key]!![maxTs]!!
        }
    }
}
