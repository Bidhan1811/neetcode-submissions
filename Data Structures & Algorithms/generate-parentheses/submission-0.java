class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve(n, ans, new StringBuilder(), 0, 0);
        return ans;
    }
    public void solve(int n, List<String> ans, StringBuilder temp, int open , int close) {
        if(temp.length() == 2 * n) {
            ans.add(temp.toString());
            return;
        }
        else if(open == close) {
            temp.append("(");
            solve(n, ans, temp, open + 1, close);
            temp.deleteCharAt(temp.length() - 1);
        }
        else if(open == n) {
            temp.append(")");
            solve(n, ans, temp, open, close + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
        else if(open > close) {
            temp.append("(");
            solve(n, ans, temp, open + 1, close);
            temp.deleteCharAt(temp.length() - 1);
            temp.append(")");
            solve(n, ans, temp, open, close + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
