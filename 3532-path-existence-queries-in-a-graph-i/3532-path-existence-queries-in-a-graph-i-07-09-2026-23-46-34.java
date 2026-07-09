class Solution 
{
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) 
    {
        int[] components=new int[n];
        Arrays.fill(components, -1);
        int component=0;
        components[0]=component;
        for(int i=1; i<n; i++)
        {
            if(nums[i]-nums[i-1] > maxDiff)
            {
                component++;
            }
            components[i]=component;
        }

        int m=queries.length;
        boolean[] res=new boolean[m];
        for(int i=0; i<m; i++)
        {
            int[] query=queries[i];
            res[i] = components[query[0]]==components[query[1]];
        }
        return res;
    }
}
