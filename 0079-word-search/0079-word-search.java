class Solution {
    boolean res = false;
    public void solve(char[][] board,String word,int ind,int i,int j ,int n,int m,boolean[][] vis)
    {
        if(ind == word.length()) 
        {
            res = true;
            return;
        }
        if(i < 0 || i >= n || j < 0 || j >= m || vis[i][j] || word.charAt(ind) != board[i][j]) return;
        vis[i][j] = true;
        solve(board,word,ind+1,i+1,j,n,m,vis);
        solve(board,word,ind+1,i-1,j,n,m,vis);
        solve(board,word,ind+1,i,j+1,n,m,vis);
        solve(board,word,ind+1,i,j-1,n,m,vis);
        vis[i][j] = false;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < m ; j++)
            {
                
                solve(board,word,0,i,j,n,m,vis);
                if(res) return true;
            }
        }
        return false;
    }
}