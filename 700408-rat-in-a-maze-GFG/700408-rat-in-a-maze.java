class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) 
    {
        ArrayList<String> res=new ArrayList<>();
        dfs(maze, 0, 0, res, new StringBuilder(""));
        return res;
    }
    public void dfs(int[][] maze, int r, int c, ArrayList<String> res, StringBuilder sb)
    {
        int n=maze.length;
        if(r<0 || r>=n || c<0 || c>=n || maze[r][c]!=1) return;
        if(r==n-1 && c==n-1)
        {
            res.add(sb.toString());
            return;
        }

        int cur=maze[r][c];
        maze[r][c]=2; //mark as visited
         
        //Down
        sb.append('D');
        dfs(maze, r+1, c, res, sb);
        sb.deleteCharAt(sb.length()-1);
        
        //Left
        sb.append('L');
        dfs(maze, r, c-1, res, sb);
        sb.deleteCharAt(sb.length()-1);
        
        //Right
        sb.append('R');
        dfs(maze, r, c+1, res, sb);
        sb.deleteCharAt(sb.length()-1);
        
        //Up
        sb.append('U');
        dfs(maze, r-1, c, res, sb);
        sb.deleteCharAt(sb.length()-1);
        
        maze[r][c]=cur;
        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna