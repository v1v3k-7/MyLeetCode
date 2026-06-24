class Solution {
    //BruteForce - sabka degree nikalo jiska (n-1)/edges/edges.len k barbar ho wahi hai center
    public int findCenter(int[][] edges) 
    {
        int n=edges.length;
        Map<Integer, Integer> freqMap=new HashMap<>();
        for(int[] edge: edges)
        {
            int i=edge[0];
            int j=edge[1];
            int edgeI=freqMap.getOrDefault(i, 0)+1;
            int edgeJ=freqMap.getOrDefault(j, 0)+1;
            if(edgeI==n) return i;
            if(edgeJ==n) return j;
            freqMap.put(i, edgeI);
            freqMap.put(j, edgeJ);
        }
        return -1;
    }
}