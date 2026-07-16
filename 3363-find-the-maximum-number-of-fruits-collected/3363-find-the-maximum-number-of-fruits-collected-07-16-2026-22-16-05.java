class Solution 
{
    int n;
    int[][] dp;
    public int maxCollectedFruits(int[][] fruits) 
    {
        n=fruits.length;
        dp=new int[n][n]; //dp[i][j] -> max fruit we can collect, when we reach [i][j] from source
        int c1=0; //collected by child 1
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(i==j) c1+=fruits[i][j];

                if(i<j && i+j<n-1) dp[i][j]=0;
                else if(j<i && i+j<n-1) dp[i][j]=0;
                else dp[i][j]=fruits[i][j];
            }
        }

        //collect from child2
        for(int i=1; i<n; i++)
        {
            for(int j=i+1; j<n; j++) //for child2 j should be always greater than i (tabi n moves me last cell tak pahuch payega)
            {
                int res=Math.max(dp[i-1][j], dp[i-1][j-1]);
                if(j<n-1) res=Math.max(res, dp[i-1][j+1]);
                dp[i][j]+=res;
            }
        }

        //collect from child3
        for(int j=1; j<n; j++)
        {
            for(int i=j+1; i<n; i++) //for child3 j should be less than i (tabi n moves me last cell tak pahuch payega)
            {
                int res=Math.max(dp[i][j-1], dp[i-1][j-1]);
                if(i<n-1) res=Math.max(res, dp[i+1][j-1]);
                dp[i][j]+=res;
            }
        }
        int c2=dp[n-2][n-1];
        int c3=dp[n-1][n-2];
        return c1+c2+c3;
    }

    // private int child1Collection(int[][] fruits)
    // {
    //     int count=0;
    //     for(int i=0; i<n; i++) count+=fruits[i][i];
    //     return count;
    // }
    // private int child2Collection(int i, int j, int[][] fruits)
    // {
    //     if(i>=n || j>=n || j<0) return 0;
    //     if(i==n-1 && j==n-1) return 0; //bcz last fruit is already collected by child1
    //     if(i>=j) return 0;

    //     if(dp[i][j]!=-1) return dp[i][j];

    //     int bottom=child2Collection(i+1, j, fruits);
    //     int bottomLeft=child2Collection(i+1, j-1, fruits);
    //     int bottomRight=child2Collection(i+1, j+1, fruits);

    //     return dp[i][j]=fruits[i][j]+Math.max(bottom, Math.max(bottomLeft, bottomRight));
    // }
    // private int child3Collection(int i, int j, int[][] fruits)
    // {
    //     if(i>=n || j>=n || i<0) return 0;
    //     if(i==n-1 && j==n-1) return 0; //bcz last fruit is already collected by child1
    //     if(i<=j) return 0;

    //     if(dp[i][j]!=-1) return dp[i][j];

    //     int left=child3Collection(i, j+1, fruits);
    //     int leftUp=child3Collection(i-1, j+1, fruits);
    //     int leftDown=child3Collection(i+1, j+1, fruits);

    //     return dp[i][j]=fruits[i][j]+Math.max(left, Math.max(leftUp, leftDown));
    // }
}