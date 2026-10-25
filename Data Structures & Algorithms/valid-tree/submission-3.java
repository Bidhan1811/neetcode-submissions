class Solution {
    public boolean validTree(int n, int[][] edges) {
    //     List<List<Integer>> adj = new ArrayList<>();
    //     for(int i = 0; i < n; i++) {
    //         adj.add(new ArrayList<>());
    //     }
    //     for(int[] row: edges) {
    //         int a = row[0];
    //         int b = row[1];
    //         adj.get(a).add(b);
    //         adj.get(b).add(a);
    //     }
    //     int[] vis = new int[n];
        
    //     if(hasCycle(0, adj, vis, -1)) return false;
            
    //     for(int i = 0; i < n; i++) {
    //         if(vis[i] != 1) return false;
    //     }
    //     return true;
    // }
    // public boolean hasCycle(int node, List<List<Integer>> adj, int[] vis, int parent) {
    //     vis[node] = 1;
    //     for(int neigh: adj.get(node)) {
    //         if(neigh == parent) continue;
    //         if(vis[neigh] != 0) return true;
    //         if(hasCycle(neigh, adj, vis, node)) return true;
    //     }
    //  return false;
    //Union-Find solution
        DSU dsu = new DSU(n);
        if(edges.length != n-1) return false;
        for(int[] edge: edges){
            if(dsu.find(edge[0], edge[1])) return false;
            dsu.union(edge[0], edge[1]);
        }
        return true;
    }
}
class DSU {
    private int[] parent;
    private int[] size;
    public DSU(int n) {
        parent = new int[n];
        size = new int[n];
        Arrays.fill(size, 1);
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    public int findParent(int node) {
        if(parent[node] == node) return node;
        parent[node] = findParent(parent[node]);
        return parent[node];
    }
    public void union(int u, int v) {
        int uParent = findParent(u);
        int vParent = findParent(v);
        if(uParent == vParent) return;
        if(size[uParent] < size[vParent]) {
            int temp = uParent;
            uParent = vParent;
            vParent = temp;
        }
        parent[vParent] = uParent;
        size[uParent] += size[vParent];
    }
    public boolean find(int u, int v) {
        return findParent(u) == findParent(v);
    }
    
}