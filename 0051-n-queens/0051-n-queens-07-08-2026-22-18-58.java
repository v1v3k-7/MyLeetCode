class Solution 
{
    List<List<String>> res=new ArrayList<>();
    int MOD;
    boolean[] digonal, antiDigonal, upward;

    public List<List<String>> solveNQueens(int n) 
    {
        MOD=n*2;
        digonal=new boolean[MOD];
        antiDigonal=new boolean[MOD];
        upward=new boolean[n];

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
            int digo=row+col;
            int antiDigo=(row-col + MOD) % MOD;
            if(upward[col] || digonal[digo] || antiDigonal[antiDigo]) continue;

            digonal[digo]=true;
            antiDigonal[antiDigo]=true;
            upward[col]=true;
            board[row][col]='Q';
            dfs(board, row+1);
            board[row][col]='.';
            digonal[digo]=false;
            antiDigonal[antiDigo]=false;
            upward[col]=false;
        }
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