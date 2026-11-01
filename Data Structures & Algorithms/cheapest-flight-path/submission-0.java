class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] flight: flights) {
            adj.get(flight[0]).add(new int[]{flight[2], flight[1]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[][] vis = new int[k+2][n];
        for(int[] row: vis) Arrays.fill(row, Integer.MAX_VALUE);
        vis[0][src] = 0;
        pq.add(new int[]{0, 0, src});
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currPrice = curr[0], node = curr[2], stop = curr[1];
            if(node == dst) return currPrice;
            for(int[] neigh: adj.get(node)) {
                int newPrice = currPrice + neigh[0];
                int next = neigh[1];
                if(stop < k+1 && vis[stop + 1][next] > newPrice) {
                    vis[stop+1][next] = newPrice;
                    pq.add(new int[]{newPrice, stop+1, next});
                }
            }
        }
        return -1;
    }
}
