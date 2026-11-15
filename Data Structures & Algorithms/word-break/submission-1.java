class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        return solve(s, 0, wordDict, dp);
    }
    public boolean solve(String s, int i, List<String> wordDict, Boolean[] dp) {
        if(i == s.length()) return true;
        if(dp[i] != null) return dp[i];
        for(int k = i; k < s.length(); k++) {
            if(wordDict.contains(s.substring(i, k+1))) {
                if(solve(s, k+1, wordDict, dp)) return dp[i] = true;
            }
        }
        return dp[i] = false;
    }
}
