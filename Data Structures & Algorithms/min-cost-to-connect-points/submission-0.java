class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new ArrayList<>();

        for(int i = 0; i < points.length - 1; i++) {
            for(int j = i + 1; j < points.length; j++) {
                int dist = Math.abs(points[i][0] - points[j][0])
                        + Math.abs(points[i][1] - points[j][1]);

                edges.add(new int[]{i, j, dist});
            }
        }
        edges.sort((a, b) -> Integer.compare(a[2], b[2]));
        int n = points.length;
        int[] parent = new int[n];
        int[] size = new int[n];

        for(int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        int totalWeight = 0;
        int count = 0;
        for(int[] edge: edges) {
            if(!union(edge[0], edge[1], parent, size)) continue;
            totalWeight += edge[2];
            count++;
            if(count == n-1) break;
        }
        return totalWeight;
    }
    public int findParent(int node, int[] parent) {
        if(parent[node] == node) return node;
        parent[node] = findParent(parent[node], parent);
        return parent[node];
    }
    public boolean union(int u, int v, int[] parent, int[] size) {
        int uPar = findParent(u, parent);
        int vPar = findParent(v, parent);
        if(uPar == vPar) return false;
        if(size[uPar] < size[vPar]) {
            int temp = uPar;
            uPar = vPar;
            vPar = temp;
        }
        parent[vPar] = uPar;
        size[uPar] += size[vPar];
        return true;
    }
}
