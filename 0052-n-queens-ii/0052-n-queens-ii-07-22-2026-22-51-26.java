class Solution {
    public int totalNQueens(int n) 
    {
        boolean[] board=new boolean[n*n];
        return solve(n, 0, board);
    }
    private int solve(int n, int col, boolean[] board)
    {
        if(col==n) return 1;

        int res=0;
        for(int r=0; r<n; r++)
        {
            if(isPossible(board, r, col, n))
            {
                board[r*n+col]=true;
                res+=solve(n, col+1, board);
                board[r*n+col]=false;
            }
        }
        return res;
    }
    private boolean isPossible(boolean[] board, int row, int col, int n)
    {
        for(int k=1; k<n; k++)
        {
            int j=col-k;
            if(j<0) break;
            //left
            if(board[row*n + j]) return false;
            //digo up
            int r=row-k;
            if(r>=0 && board[r*n + j]) return false;
            //digo down
            r=row+k;
            if(r<n && board[r*n +j]) return false;
        }
        return true;
    }
}