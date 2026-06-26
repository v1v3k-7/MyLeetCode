class Solution 
{
    //BFS
    int rows;
    int cols;
    public int numIslands(char[][] grid) 
    {
        //we will mark visited by 2;
        rows=grid.length;
        cols=grid[0].length;
        int islands=0;
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                if(grid[i][j]!='1') continue; //visited or water cell, no need to bds again here so continue;
                islands++;
                grid[i][j]='2'; //mark as visited
                BFS(grid, i, j);
            }
        }
        return islands;
    }

    public void BFS(char[][] grid, int row, int col)
    {
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{row, col});
        while(!queue.isEmpty())
        {
            int[] cell=queue.poll();
            int row_=cell[0], col_=cell[1];
            int[][] directions={{row_-1, col_}, {row_+1, col_}, {row_, col_-1}, {row_, col_+1}};
            for(int[] dir: directions)
            {
                int r=dir[0], c=dir[1];
                if(r>=rows||r<0||c>=cols||c<0||grid[r][c]!='1') continue;
                grid[r][c]=2; //mark as visited by '2';
                queue.offer(new int[]{r, c});
            }
        }
    }
}