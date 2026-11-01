class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> vis = new HashMap<>();
        Stack<Character> st = new Stack<>();
        for(String word: words) {
            for(char c: word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
            }
        }
        for(int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i+1];
            int minLen = Math.min(w1.length(), w2.length());
            if(w1.length() > w2.length() && 
   w1.startsWith(w2)) return "";
            for(int j = 0; j < minLen; j++) {
                if(w1.charAt(j) != w2.charAt(j)) {
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }
        for(char c: adj.keySet()) {
            if(!vis.containsKey(c))
                if(!dfs(c, vis, adj, st)) return "";
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()) {
            ans.append(st.pop());
        }
        return ans.toString();
    }
    public boolean dfs(char c, Map<Character, Integer> vis, Map<Character, Set<Character>> adj, Stack<Character> ans) {
        vis.put(c, 1);
        for(char neigh: adj.get(c)) {
            if(!vis.containsKey(neigh)) {
                if(!dfs(neigh, vis, adj, ans)) return false;
            }
            else if(vis.get(neigh) == 1) return false;
        }
        vis.put(c, 2);
        ans.push(c);
        return true;
    }
}
