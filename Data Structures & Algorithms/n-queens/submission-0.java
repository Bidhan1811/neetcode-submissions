class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] mat = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                mat[i][j] = '.';
            }
        }
        solve(n, ans, mat, 0);
        return ans;
    }
    public void solve(int n, List<List<String>> ans, char[][] mat, int r) {
        if(r == n) {
            List<String> row = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                StringBuilder temp = new StringBuilder();
                for(int j = 0; j < n; j++) {
                    temp.append(mat[i][j]);
                }
                row.add(temp.toString());
            }
            ans.add(row);
            return;
        }
        for(int i = 0; i < n; i++) {
            if(isSafe(n, r, i, mat)) {
                mat[r][i] = 'Q';
                solve(n, ans, mat, r+1);
                mat[r][i] = '.';
            }
        }
    }
    public boolean isSafe(int n, int r, int c, char[][] mat) {
        for(int i = 0; i < r; i++) {
            if(mat[i][c] == 'Q') return false;
        }
        int i = r - 1, j = c - 1;
        while(i >= 0 && j >= 0) {
            if(mat[i][j] == 'Q') return false;
            i--;
            j--;
        }
        i = r-1; j = c + 1;
        while(i >= 0 && j < n) {
            if(mat[i][j] == 'Q') return false;
            i--;
            j++;
        }
        return true;
    }
}
