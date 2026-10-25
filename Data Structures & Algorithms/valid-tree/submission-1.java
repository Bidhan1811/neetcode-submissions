class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] row: edges) {
            int a = row[0];
            int b = row[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        int[] vis = new int[n];
        
        if(hasCycle(0, adj, vis, -1)) return false;
            
        for(int i = 0; i < n; i++) {
            if(vis[i] != 1) return false;
        }
        return true;
    }
    public boolean hasCycle(int node, List<List<Integer>> adj, int[] vis, int parent) {
        vis[node] = 1;
        for(int neigh: adj.get(node)) {
            if(neigh == parent) continue;
            if(vis[neigh] != 0) return true;
            if(hasCycle(neigh, adj, vis, node)) return true;
        }
     return false;
    }
}
