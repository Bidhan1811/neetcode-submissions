class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] p: prerequisites) {
            int a = p[0];
            int b = p[1];
            adj.get(b).add(a);
        }
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            for(int n: adj.get(i)) {
                indegree[n]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) q.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for(int neigh: adj.get(node)) {
                indegree[neigh]--;
                if(indegree[neigh] == 0) q.add(neigh);
            }
        }
        if(ans.size() != numCourses) return new int[0];
        int[] res = new int[numCourses];
        for(int num: ans) {
            res[i++] = num;
        }
        return res;
    }
}
