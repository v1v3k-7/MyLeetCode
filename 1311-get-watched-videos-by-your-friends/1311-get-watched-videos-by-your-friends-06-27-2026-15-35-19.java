class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) 
    {
        List<String> res=new ArrayList<>();

        // int n=friends.length;
        Set<Integer> visited=new HashSet<>();
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(id);
        visited.add(id);
        int curlevel=0;

        TreeMap<String, Integer> resMap=new TreeMap<>();
        while(!queue.isEmpty())
        {
            int size=queue.size();
            for(int i=0; i<size; i++)
            {
                int node=queue.poll();
                if(curlevel==level)
                {
                    for(String s: watchedVideos.get(node))
                    {
                        resMap.merge(s, 1, Integer::sum);
                    }
                    continue;
                }
                int[] nodeNeighbour=friends[node];
                for(int n: nodeNeighbour)
                {
                    if(visited.contains(n)) continue;
                    queue.offer(n);
                    visited.add(n);
                }
            }
            curlevel++;
        }
        // System.out.println(resMap);
        res.addAll(resMap.keySet());
        res.sort( (a, b) -> 
            {
                int cmp=Integer.compare(resMap.get(a), resMap.get(b));
                if(cmp==0) return a.compareTo(b);
                return cmp;
            });
        return res;
    }
}