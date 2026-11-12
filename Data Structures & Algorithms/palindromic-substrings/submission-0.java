class Solution {
    public int countSubstrings(String s) {
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i = 0; i < s.length(); i++){
            cnt1 += solve(s, i, i);
            cnt2 += solve(s, i, i+1);
        }
        return cnt1 + cnt2;
    }
    public int solve(String s, int start, int end) {
        int left = start;
        int right = end;
        int cnt = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            cnt++;
            left--;
            right++;
        }
        return cnt;
    }
}
