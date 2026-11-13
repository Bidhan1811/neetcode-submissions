class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp, -1);
        return solve(0, s, dp);
    }
    public int solve(int i, String s, int[] dp) {
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;
        if(dp[i] != -1) return dp[i];
        int cnt1 = solve(i+1, s, dp);
        int cnt2 = 0;
        if(i + 1 < s.length()) {
            int num = Integer.parseInt(s.substring(i, i+2));
            if(num >= 10 && num <= 26) cnt2 = solve(i+2, s, dp);
        }
        return dp[i] = cnt1 + cnt2;
    }
}
