class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int cnt = 0;
        for(int[] edge: edges) {
            dsu.union(edge[0], edge[1]);
        }
        for(int i = 0; i < n; i++) {
            if(dsu.findParent(i) == i) cnt++;
        }
        return cnt;
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
