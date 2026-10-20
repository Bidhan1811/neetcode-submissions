class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        solve(s, ans, new ArrayList<>(), 0);
        return ans;
    }
    public void solve(String s, List<List<String>> ans,List<String> temp, int i)  {

        if (i == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            String sub = s.substring(i, j + 1);

            if (isPalindrome(sub)) {
                temp.add(sub);
                solve(s, ans, temp, j + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }

        return true;
    }
}
