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
        TreeMap<Integer, List<Integer>> freqMap=new TreeMap<>(Comparator.reverseOrder());
        for(int i=0; i<n; i++)
        {
            freqMap.putIfAbsent(degree[i], new ArrayList<>());
            freqMap.get(degree[i]).add(i);
        }
        // System.out.println(freqMap);
        long res=0;
        long value=n;
        for(Map.Entry<Integer, List<Integer>> e: freqMap.entrySet())
        {
            int key=e.getKey();
            for(int node: e.getValue())
            {
                res+=(long)value*key;
                value--;
            }
        }
        return res;
    }
}