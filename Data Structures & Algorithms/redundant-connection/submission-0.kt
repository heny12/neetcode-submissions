class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        // Create graph representation
        val graph = mutableMapOf<Int,MutableList<Int>>()
        edges.forEach { edge ->
            graph.getOrPut(edge[0]) { mutableListOf() }.add(edge[1])
            graph.getOrPut(edge[1]) { mutableListOf() }.add(edge[0])
        }

        // Iterate edges
            // check if node connect without edge (bfs)
            // if so set as connection to remove
            // otherwise continue
        var ret = intArrayOf()
        edges.forEach { edge ->
            val visited = mutableSetOf<Int>(edge[0])
            val queue = ArrayDeque<Int>()
            graph[edge[0]]!!.forEach { connectingNode ->
                if (connectingNode != edge[1]) {
                    queue.add(connectingNode)
                }
            }
            while (queue.isNotEmpty()) {
                val node = queue.removeFirst()
                if (!visited.contains(node)) {
                    visited.add(node)
                    if (node == edge[1]) {
                        ret = edge
                        queue.clear()
                    } else {
                        graph[node]!!.forEach { connectingNode ->
                            queue.add(connectingNode)
                        }
                    }
                }
            }
        }
        return ret
    }
}
