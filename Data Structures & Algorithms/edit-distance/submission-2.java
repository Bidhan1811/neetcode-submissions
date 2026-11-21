class Solution {
    public int minDistance(String word1, String word2) {
        int maxLen = 0;
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] r: dp) Arrays.fill(r, -1);
        return solve(0, 0, word1, word2, dp);
    }
    public int solve(int i, int j, String word1, String word2, int[][] dp) {
        if(j >= word2.length()) return word1.length() - i;
        if(i >= word1.length()) return word2.length() - j;
        if(dp[i][j] != -1) return dp[i][j];
        if(word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = solve(i+1, j+1, word1, word2, dp);
        }
        int ins = 1 + solve(i, j+1, word1, word2, dp);
        int del = 1 + solve(i+1, j, word1, word2, dp);
        int rep = 1 + solve(i+1, j+1, word1, word2, dp);
        return dp[i][j] = Math.min(ins, Math.min(del, rep));
    }
}
