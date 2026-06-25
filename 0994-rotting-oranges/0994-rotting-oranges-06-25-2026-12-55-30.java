class Solution 
{
    //BFS level wise
    public int orangesRotting(int[][] grid) 
    {
        int rows=grid.length;
        int cols=grid[0].length;

        Queue<int[]> queue=new LinkedList<>();

        for(int r=0; r<rows; r++)
        {
            for(int c=0; c<cols; c++) 
            {
                if(grid[r][c]==2)
                {
                    queue.offer(new int[]{r,c});
                    // break;
                }
            }
        }
        
        int min=0;
        while(!queue.isEmpty())
        {
            int size=queue.size();
            min++;
            for(int i=0; i<size; i++)
            {
                int[] cur=queue.poll();
                int row=cur[0], col=cur[1];
                int[][] directions={{row-1, col}, {row+1, col}, {row, col-1}, {row,col+1}};
                for(int[] dir: directions)
                {
                    int r=dir[0], c=dir[1];
                    if(r>=rows||r<0||c>=cols||c<0||grid[r][c]!=1) continue;

                    grid[r][c]=2; //marked as visited or rooten
                    queue.offer(new int[]{r, c});
                }
            }
        }
        for(int[] row: grid)
        {
            for(int cell: row) 
            {
                if(cell==1) return -1;
            }
        }
        return (min==0)?0:min-1;
    }
}