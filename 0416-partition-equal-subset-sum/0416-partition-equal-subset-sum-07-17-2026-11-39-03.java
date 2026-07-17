class Solution {
    public boolean canPartition(int[] nums) 
    {
        int total=0;
        int n=nums.length;
        for(int no: nums) total+=no;
        if((total&1)==1) return false;

        int target=total/2;
        boolean[][] dp=new boolean[n+1][target+1]; //dp[i][j] -> 0:i tak k sets mese kisi subsets se j bn skta ya nhi sum kr k
        //befault first row 0 hoga, kyuki null subset se koi b sum nhi bna skte except zero

        for(int i=0; i<=n; i++) dp[i][0]=true; //first col always true, kyuki sum=0 to bna hi skte hain kisi b subset se (be null subset)

        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=target; j++)
            {
                boolean pick=false;
                if(nums[i-1]<=j) 
                {
                    int remain=j-nums[i-1];
                    pick=dp[i-1][remain];
                }
                boolean noPick=dp[i-1][j];

                dp[i][j]=pick||noPick;
            }
        }

        return dp[n][target];
    }
    // private boolean solve(int idx, int target, int[] nums, Boolean[][] dp)
    // {
    //     if(target==0) return true;
    //     if(idx==0)
    //     {
    //         if(nums[idx]==target) return true;
    //         else return false;
    //     }

    //     if(dp[idx][target]!=null) return dp[idx][target];

    //     if(nums[idx]<=target)
    //     {
    //         boolean pick=solve(idx-1, target-nums[idx], nums, dp);
    //         if(pick) return true;
    //     }
    //     boolean noPick=solve(idx-1, target, nums, dp);
    //     return dp[idx][target]=noPick;
    // }
}