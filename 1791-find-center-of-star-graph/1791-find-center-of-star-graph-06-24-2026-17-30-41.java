class Solution {
    //BruteForce - sabka degree nikalo jiska (n-1)/edges/edges.len k barbar ho wahi hai center
    public int findCenter(int[][] edges) 
    {
        int n=edges.length;
        int[] arr=new int[n+1];
        for(int[] edge: edges)
        {
            int i=edge[0];
            int j=edge[1];
            arr[i-1]++;
            arr[j-1]++;
            if(arr[i-1]==n) return i;
            if(arr[j-1]==n) return j;
        }
        return -1;
    }
}