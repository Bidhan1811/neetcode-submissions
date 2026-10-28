class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> adj = new HashMap<>();
        for(int i = 0; i < tickets.size(); i++) {
            String from = tickets.get(i).get(0);
            String to = tickets.get(i).get(1);
            adj.computeIfAbsent(from, x -> new ArrayList<>()).add(to);
        }
        for (List<String> destinations : adj.values()) {
            Collections.sort(destinations);
        }
        List<String> ans = new ArrayList<>();
        dfs("JFK", adj, ans);
        Collections.reverse(ans);
        return ans;
    }
    public void dfs(String airport, Map<String, List<String>> adj, List<String> ans) {
        while(adj.containsKey(airport) && !adj.get(airport).isEmpty()) {
            String next = adj.get(airport).remove(0);
            dfs(next, adj, ans);
        }
        ans.add(airport);
    }
}
