class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> travelTimes = new HashMap();
        Map<Integer, Integer> shortest = new HashMap();

        for (int i = 0; i < n; i++) {
            travelTimes.put(i + 1, new HashMap());
            shortest.put(i + 1, -1);
        }

        for (int i = 0; i < times.length; i++) {
            int[] time = times[i];
            travelTimes.get(time[0]).put(time[1], time[2]);
        }

        Queue<Integer> queue = new LinkedList();
        queue.offer(Integer.valueOf(k));
        shortest.put(Integer.valueOf(k), 0);

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            for (Integer neighbor : travelTimes.get(node).keySet()) {
                Integer travelTime = shortest.get(node) + travelTimes.get(node).get(neighbor);
                if (shortest.get(neighbor) == -1 || shortest.get(neighbor) > travelTime) {
                    shortest.put(neighbor, travelTime);
                    queue.add(neighbor);
                }
            }
        }

        int max = 0;
        for (Integer node : shortest.keySet()) {
            if (shortest.get(node).equals(-1)) {
                return -1;
            } else {
                max = Math.max(max, shortest.get(node));
            }
        }

        return max;
    }
}
