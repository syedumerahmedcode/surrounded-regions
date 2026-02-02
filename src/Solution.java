public class Solution {

    public void solve(char[][] board) {
        /**
         * We iterate through all the boundary nodes till we find a 'O'. On this 'O' found, 
         * we do a DFS in all 4 directed and find all nodes that are also 'O'.
         * 
         * At the end, all nodes that remain will be marked with 'X' and that will be the answer.
         *  */
        if (board == null || board.length == 0) {
            //edge case scenario
            return;
        }
        int m = board.length;
        int n = board[0].length;
        /**
         * Mark boundary-connected 'O's with 'T'
         */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // check for edge nodes
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }
        
        /**
         * capture surrounded regions and revert 'T' to 'O'
         */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
         
    }

    private void dfs(char[][] board, int i, int j){
        if(i<0|| i>=board.length|| j<0||j>=board[i].length|| board[i][j]!='O'){
            return;
        }
        // mark as visited
        board[i][j]='T'; 
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);

    }

}
