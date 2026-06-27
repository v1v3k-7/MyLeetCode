
class Solution 
{
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) 
    {
        Set<Integer> visited=new HashSet<>();
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(id);
        visited.add(id);
        int curlevel=0;

        while(!queue.isEmpty())
        {
            int size=queue.size();
            for(int i=0; i<size; i++)
            {
                int node=queue.poll();
                int[] nodeNeighbour=friends[node];
                for(int n: nodeNeighbour)
                {
                    if(visited.contains(n)) continue;
                    queue.offer(n);
                    visited.add(n);
                }
            }
            curlevel++;
            if(curlevel==level) break;
        }
        //queue store only our needed IDs

        HashMap<String,Integer> freqMap = new HashMap<>();
        while(!queue.isEmpty()){
            int curId = queue.poll();
            for(String video : watchedVideos.get(curId)){
                freqMap.merge(video, 1, Integer::sum);
            }
        }
        List<String> res=new ArrayList<>(freqMap.keySet());
        res.sort((a,b) -> 
        {
            int cmp=Integer.compare(freqMap.get(a), freqMap.get(b));
            if(cmp==0) return a.compareTo(b);
            return cmp;
        });
        return res;
    }
}