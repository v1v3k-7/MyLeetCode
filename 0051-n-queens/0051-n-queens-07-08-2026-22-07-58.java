class Solution 
{
    List<List<String>> res=new ArrayList<>();
    Set<Integer> digonal=new HashSet<>();
    Set<Integer> antiDigonal=new HashSet<>();
    Set<Integer> upward=new HashSet<>();

    public List<List<String>> solveNQueens(int n) 
    {
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
            int antiDigo=row-col;
            
            if(upward.contains(col) || digonal.contains(digo) || antiDigonal.contains(antiDigo)) 
                continue;

            digonal.add(digo);
            antiDigonal.add(antiDigo);
            upward.add(col);
            board[row][col]='Q';
            dfs(board, row+1);
            board[row][col]='.';
            digonal.remove(digo);
            antiDigonal.remove(antiDigo);
            upward.remove(col);
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