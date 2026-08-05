class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) 
    {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        boolean[] suspicious=new boolean[n]; //check if node-1 is suspicious or not or node-0,3,4...
        int[] indegree=new int[n];
        for(int[] edge: invocations)
        {
            adj.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        //BFS to mark suspicious
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(k);
        suspicious[k]=true;
        while(!queue.isEmpty())
        {
            int cur=queue.poll();
            for(int neighbour: adj.get(cur))
            {
                indegree[neighbour]--;
                if(suspicious[neighbour]==false)
                {
                    suspicious[neighbour]=true;
                    queue.offer(neighbour);
                }
            }
        }

        List<Integer> res=new ArrayList<>();
        boolean cannotRemove=false;
        for(int i=0; i<n; i++)
        {
            if(suspicious[i] && indegree[i]!=0)
            {
                cannotRemove=true;
                break;
            }
            if(!suspicious[i]) res.add(i);
        }
        if(!cannotRemove) return res;
        else
        {
            res.clear();
            for(int i=0; i<n; i++) res.add(i);
            return res;
        }
    }
}