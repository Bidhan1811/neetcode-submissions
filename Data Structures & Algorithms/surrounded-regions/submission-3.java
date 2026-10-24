class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == m-1 || j == n-1 || i == 0 || j == 0) {
                    if(board[i][j] == 'O') dfs(i, j, board);
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == 'R') board[i][j] = 'O';
            }
        }
    }
    public void dfs(int i, int j, char[][] board) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == 'R') return;
        board[i][j] = 'R';
        dfs(i+1, j, board);
        dfs(i, j+1, board);
        dfs(i-1, j, board);
        dfs(i, j-1, board);
    }
}
