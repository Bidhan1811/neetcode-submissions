class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        for(int i = 0; i < s.length(); i++)  {
            String s1 = solve(i, i, s);
            String s2 = solve(i, i+1, s);
            if(s1.length() > ans.length()) ans = s1;
            if(s2.length() > ans.length()) ans = s2;
        }
        return ans;
    }
    public String solve(int l, int r, String s) {
        int left =  l;
        int right = r;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
}
