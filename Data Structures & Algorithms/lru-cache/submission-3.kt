class LRUCache(val capacity: Int) {

    class Node(
        val key: Int = 0,
        var value: Int = 0,
        var prev: Node? = null,
        var next: Node? = null
    )

    private val map = mutableMapOf<Int, Node>()
    private val head = Node()
    private val tail = Node()

    init {
        head.next = tail
        tail.prev = head
    }

    private fun remove(node: Node) {
        val prevNode = node.prev
        val nextNode = node.next
        prevNode?.next = nextNode
        nextNode?.prev = prevNode
    }

    private fun insert(node: Node) {
        val prevNode = tail.prev
        prevNode?.next = node
        node.prev = prevNode
        node.next = tail
        tail.prev = node
    }

    fun get(key: Int): Int {
        val node = map[key] ?: return -1
        remove(node)
        insert(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        if (key in map) {
            val node = map[key]!!
            node.value = value
            remove(node)
            insert(node)
        } else {
            if (map.size >= capacity) {
                val lru = head.next!!
                remove(lru)
                map.remove(lru.key)
            }
            val newNode = Node(key, value)
            map[key] = newNode
            insert(newNode)
        }
    }
}