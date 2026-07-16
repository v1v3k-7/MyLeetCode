class Solution 
{
    int n;
    int[][] dp;
    public int maxCollectedFruits(int[][] fruits) 
    {
        n=fruits.length;
        dp=new int[n][n];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);

        int child1=child1Collection(fruits);
        int child2=child2Collection(0, n-1, fruits);
        int child3=child3Collection(n-1, 0, fruits);

        return child1+child2+child3;
    }
    
    private int child1Collection(int[][] fruits)
    {
        int count=0;
        for(int i=0; i<n; i++) count+=fruits[i][i];
        return count;
    }
    private int child2Collection(int i, int j, int[][] fruits)
    {
        if(i>=n || j>=n || j<0) return 0;
        if(i==n-1 && j==n-1) return 0; //bcz last fruit is already collected by child1
        if(i>=j) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int bottom=child2Collection(i+1, j, fruits);
        int bottomLeft=child2Collection(i+1, j-1, fruits);
        int bottomRight=child2Collection(i+1, j+1, fruits);
        
        return dp[i][j]=fruits[i][j]+Math.max(bottom, Math.max(bottomLeft, bottomRight));
    }
    private int child3Collection(int i, int j, int[][] fruits)
    {
        if(i>=n || j>=n || i<0) return 0;
        if(i==n-1 && j==n-1) return 0; //bcz last fruit is already collected by child1
        if(i<=j) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int left=child3Collection(i, j+1, fruits);
        int leftUp=child3Collection(i-1, j+1, fruits);
        int leftDown=child3Collection(i+1, j+1, fruits);

        return dp[i][j]=fruits[i][j]+Math.max(left, Math.max(leftUp, leftDown));
    }
}