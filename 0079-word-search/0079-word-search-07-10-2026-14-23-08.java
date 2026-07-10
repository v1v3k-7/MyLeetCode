class Solution 
{
    int row, col;
    public boolean exist(char[][] board, String word) 
    {
        row=board.length;
        col=board[0].length;
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                if(dfs(board, 0, word, i, j)) return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, int idx, String word, int r, int c)
    {
        if(idx==word.length()) return true;
        if(r<0 || r>=row || c<0 || c>=col || board[r][c]!=word.charAt(idx)) return false;

        char temp=board[r][c];
        board[r][c]='$';

        boolean right=dfs(board, idx+1, word, r, c+1);
        if(right) return true;

        boolean down=dfs(board, idx+1, word, r+1, c);
        if(down) return true;

        boolean left=dfs(board, idx+1, word, r, c-1);
        if(left) return true;

        boolean up=dfs(board, idx+1, word, r-1, c);
        if(up) return true;
        
        board[r][c]=temp;

        return false;
    }
}