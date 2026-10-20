class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            if (solve(board, word, new HashSet<>(), i, j, 0)) {
                return true;
            }
        }
    }
    return false;
    }
    public boolean solve(char[][] board, String word, HashSet<String> vis, int i, int j, int k) {
        if(k == word.length()) return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if(board[i][j] != word.charAt(k)) return false;
        if(vis.contains(i + "," + j)) return false;
        vis.add(i + "," + j);
        boolean found = solve(board, word, vis, i+1, j, k+1) || solve(board, word, vis, i, j+1, k+1) || solve(board, word, vis, i-1, j, k+1) || solve(board, word, vis, i, j-1, k+1);
        vis.remove(i + "," + j);
        return found;  
    }
}
