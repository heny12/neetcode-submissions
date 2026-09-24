class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> nodes = new HashMap();
        
        for (int i = 0; i < n; i++) {
            nodes.put(i, new ArrayList());
        }

        for (int i = 0; i < edges.length; i++) {
            int n1 = edges[i][0];
            int n2 = edges[i][1];
            nodes.get(n1).add(n2);
            nodes.get(n2).add(n1);
        }

        int count = 0;
        Set<Integer> visited = new HashSet();
        for (Integer node : nodes.keySet()) {
            if (!visited.contains(node)) {
                count++;
                explore(nodes, visited, node);
            }
        }

        return count;
    }

    private void explore(Map<Integer, List<Integer>> nodes, Set<Integer> visited, Integer node) {
        if (!visited.contains(node)) {
            visited.add(node);
            for (Integer neighbor : nodes.get(node)) {
                explore(nodes, visited, neighbor);
            }
        }
    }
}
