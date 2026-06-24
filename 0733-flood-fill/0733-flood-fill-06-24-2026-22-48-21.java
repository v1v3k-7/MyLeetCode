class Solution {
    // using DFS
    int rows;
    int cols;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) 
    {
        rows=image.length;
        cols=image[0].length;
        // boolean[][] visited=new boolean[rows][cols];
        dfs(sr, sc, color, image[sr][sc], image);
        return image;
    }
    public void dfs(int r, int c, int newColor, int curColor, int[][] image)
    {
        if(r>=rows || r<0 || c>=cols || c<0 || image[r][c]!=curColor || image[r][c]==newColor)
        {
            return;
        }
        image[r][c]=newColor;
        // visited[r][c]=true;
        int[][] directions={{r-1, c}, {r+1,c}, {r, c-1}, {r, c+1}}; //up, down, left, right
        for(int[] neighbour: directions)
        {
            dfs(neighbour[0], neighbour[1], newColor, curColor, image);
        }
    }
}