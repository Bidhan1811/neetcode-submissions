class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge: times) {
            int a = edge[0];
            int b = edge[1];
            int time = edge[2];
            adj.get(a).add(new int[]{b, time});
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{0, k});
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[1];
            int currTime = curr[0];
            for(int[] neigh: adj.get(node)) {
                if(dist[neigh[0]] > currTime + neigh[1]) {
                    dist[neigh[0]] = currTime + neigh[1];
                    pq.add(new int[]{currTime+neigh[1], neigh[0]});
                }
            }
        }
        int maxTime = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}
