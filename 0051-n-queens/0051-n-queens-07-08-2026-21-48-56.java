class Solution 
{
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) 
    {
        res=new ArrayList<>();
        char[][] board=new char[n][n];
        for(int i=0; i<n; i++) Arrays.fill(board[i], '.');
        dfs(board, 0);
        return res;
    }

    private void dfs(char[][] board, int row)
    {
        int n=board.length;
        if(row==n)
        {
            constructBoard(board);
            return;
        }
        for(int col=0; col<n; col++)
        {
            if(isValid(row, col, board))
            {
                board[row][col]='Q';
                dfs(board, row+1);
                board[row][col]='.';
            }
        }
    }
    private boolean isValid(int row, int col, char[][] board)
    {
        int n=board.length;
        for(int i=1; i<n; i++)
        {
            //upward check
            int r=row-i;
            if(r>=0 && board[r][col]=='Q') return false;

            //digonal upward check
            int c=col+i;
            if(r>=0 && c<n && board[r][c]=='Q') return false;

            //antidigoanl upward check
            c=col-i;
            if(r>=0 && c>=0 && board[r][c]=='Q') return false;
        }
        return true;
    }
    private void constructBoard(char[][] board)
    {
        int n=board.length;
        List<String> list=new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            list.add(new String(board[i]));
        }
        res.add(list);
    }
}