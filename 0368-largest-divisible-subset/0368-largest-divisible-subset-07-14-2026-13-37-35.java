class Solution {
    //LIS Varient
    public List<Integer> largestDivisibleSubset(int[] nums) 
    {
        Arrays.sort(nums);
        int n=nums.length;
        int[] dp=new int[n]; //dp[i] -> Largest Divisible Subset Length ends with ith index
        int[] parent=new int[n]; //parent[i] -> ith index ka parent index like wo last index kisko le k bda bna hai length
        for(int i=0; i<n; i++)
        {
            dp[i]=1; 
            parent[i]=i; //same parent
        }

        int maxLen=1;
        int maxIndex=0;
        for(int i=1; i<n; i++)
        {
            for(int j=0; j<i; j++)
            {
                if(nums[i]%nums[j]==0)
                {
                    if(dp[j]+1>dp[i])
                    {
                        dp[i]=dp[j]+1;
                        parent[i]=j;
                    }
                }
            }
            if(dp[i]>maxLen)
            {
                maxLen=dp[i];
                maxIndex=i;
            }
        }
        List<Integer> res=new ArrayList<>(maxLen);
        res.add(nums[maxIndex]);
        while(maxIndex!=parent[maxIndex])
        {
            maxIndex=parent[maxIndex];
            res.add(nums[maxIndex]);
        }
        return res;
    }


    // //Recursion
    // private void solve(int idx, int[] nums, List<Integer> temp, int prev)
    // {
    //     if(idx==nums.length)
    //     {
    //         if(temp.size()>res.size())
    //         {
    //             res=new ArrayList<>(temp);
    //         }
    //         return;
    //     }
        
    //     int n=temp.size();
    //     //pick case
    //     if(prev==-1 || nums[idx]%nums[prev]==0)
    //     {
    //         temp.add(nums[idx]);
    //         solve(idx+1, nums, temp, idx);
    //         temp.remove(n);
    //     }
    //     //noPick case
    //     solve(idx+1, nums, temp, idx);
    // }
}