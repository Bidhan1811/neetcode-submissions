class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length()-1;
        boolean ans = true;
        s = s.toLowerCase();
        while(l <= r) {
            if(!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            if(!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if(s.charAt(l) != s.charAt(r)) {
                ans = false;
                break;
            }
            else {
                l++;
                r--;
            }
        }
        return ans;
    }
}
