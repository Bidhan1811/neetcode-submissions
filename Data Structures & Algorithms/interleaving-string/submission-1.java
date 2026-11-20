class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1];
        return solve(s1, s2, s3, 0, 0, dp);
    }
    public boolean solve(String s1, String s2, String s3, int i, int j, Boolean[][] dp) {
        if(i >= s1.length() && j >= s2.length()) return true;
        if(i < s1.length() && j < s2.length() && dp[i][j] != null) return dp[i][j];
        boolean ans1 = false;
        boolean ans2 = false;
        if(i < s1.length() && s3.charAt(i+j) == s1.charAt(i)) {
            ans1 = solve(s1, s2, s3, i+1, j, dp);
        }
        if(j < s2.length() && s3.charAt(i+j) == s2.charAt(j)) {
            ans2 = solve(s1, s2, s3, i, j+1, dp);
        }
        return dp[i][j] = ans1 || ans2;
    }
}
