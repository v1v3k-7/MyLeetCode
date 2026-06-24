class Solution 
{
    //jiski degree jyada hai wo max bar sum me participate krenge to max sum/importance pane k lie highest degree wale ko highesh value assign kro(n) and lowest degree wale ko lowest(1);
    public long maximumImportance(int n, int[][] roads) 
    {
        int[] degree=new int[n]; //0 index -> degree of '0' node, 1 index -> degree of '1' node, .....
        for(int[] route: roads)
        {
            degree[route[0]]++;
            degree[route[1]]++;
        }
        Arrays.sort(degree);
        long label=1;
        long res=0;
        for(int freq: degree)
        {
            res+=freq*label;
            label++;
        }
        return res;
    }
}