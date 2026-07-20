class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) 
    {
        List<List<Integer>> res=new ArrayList<>();
        int m=grid.length;
        int n=grid[0].length;
        int len=m*n; 
        k %= len;
        //treat it as 1D array of length len, and find i by i=x/m & j=x%n;

        for(int i=0; i<m; i++)
        {
            List<Integer> row=new ArrayList<>();
            for(int j=0; j<n; j++) row.add(0);
            res.add(row);
        }

        for(int x=0; x<len; x++)
        {
            int i=x/n; 
            int j=x%n;

            int newIndex=(x+k)%len;
            int newI=newIndex/n;
            int newJ=newIndex%n;
            res.get(newI).set(newJ, grid[i][j]);
        }
        
        return res;
         
    }
}