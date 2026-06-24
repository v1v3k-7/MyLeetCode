class Solution {
    // using BFS

    public int[][] floodFill(int[][] image, int sr, int sc, int color) 
    {
        int rows=image.length;
        int cols=image[0].length;
        int curColor=image[sr][sc];
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        while(!queue.isEmpty())
        {
            int node[]=queue.poll();
            int row=node[0], col=node[1];
            image[row][col]=color; //marked visited/filled;

            int[][] directions={{row-1, col}, {row+1,col}, {row, col-1}, {row, col+1}};
            for(int[] neighbour: directions)
            {
                int r=neighbour[0], c=neighbour[1];
                if(r>=rows || r<0 || c>=cols || c<0 || image[r][c]!=curColor || image[r][c]==color) continue;
                queue.offer(new int[]{neighbour[0], neighbour[1]});
            }
        }
        return image;
    }
}