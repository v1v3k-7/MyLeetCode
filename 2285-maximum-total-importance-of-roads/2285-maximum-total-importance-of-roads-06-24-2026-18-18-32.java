class Solution 
{
    //jiski degree jyada hai wo max bar sum me participate krenge to max sum/importance pane k lie highest degree wale ko highesh value assign kro(n) and lowest degree wale ko lowest(1);
    public long maximumImportance(int n, int[][] roads) 
    {
        int[] degree=new int[n]; //0 index -> degree of '0' node, 1 index -> degree of '1' node, .....
        for(int[] route: roads)
        {
            int i=route[0];
            int j=route[1];
            degree[i]++;
            degree[j]++;
        }
        Arrays.sort(degree);
        long value=1;
        long res=0;
        for(int freq: degree)
        {
            res+=(long)freq*value;
            value++;
        }
        return res;
    }
}