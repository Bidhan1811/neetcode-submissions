class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n);
        int[] ans = new int[2];
        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            if(dsu.findParent(u) == dsu.findParent(v)) {
                ans[0] = u;
                ans[1] = v;
            }
            dsu.union(u, v);
        }
        return ans;
    }
}
class DSU {
    private int[] parent;
    private int[] size;
    public DSU(int n) {
        parent = new int[n+1];
        size = new int[n+1];
        Arrays.fill(size, 1);
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }
    public int findParent(int node) {
        if(parent[node] == node) {
            return node;
        }
        parent[node] = findParent(parent[node]);
        return parent[node];
    }
    public void union(int u, int v) {
        int uPar = findParent(u);
        int vPar = findParent(v);
        if(uPar == vPar) return;
        if(size[uPar] < size[vPar]) {
            int temp = uPar;
            uPar = vPar;
            vPar = temp;
        }
        parent[vPar] = uPar;
        size[uPar] += size[vPar];
    }
}
