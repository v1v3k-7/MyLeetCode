class Solution 
{
    public int spanningTree(int V, int[][] edges) 
    {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[2], b[2]));
        for(int[] edge: edges)
        {
            pq.offer(new int[]{edge[0], edge[1], edge[2]});
        }
        DisjointSet dsu=new DisjointSet(V);
        int sum=0;
        ArrayList<int[]> res=new ArrayList<>();
        while(!pq.isEmpty())
        {
            int[] pair=pq.poll();
            int parent=pair[0];
            int node=pair[1];
            int wt=pair[2];
            if(dsu.unionBySize(parent, node))
            {
                sum+=wt;
                res.add(new int[]{parent, node});
            }
        }
        return sum;
    }
}

class DisjointSet
{
    int[] parent, size;
    int components;
    public DisjointSet(int nodes)
    {
        this.parent=new int[nodes];
        this.size=new int[nodes];
        this.components=nodes;
        for(int i=0; i<nodes; i++)
        {
            this.parent[i]=i;
            this.size[i]=1;
        }
    }
    public int findRootParent(int node)
    {
        if(node==parent[node]) return node;
        return parent[node]=findRootParent(parent[node]);
    }
    public boolean unionBySize(int node1, int node2)
    {
        int rootParent1=findRootParent(node1);
        int rootParent2=findRootParent(node2);
        if(rootParent1==rootParent2) return false;
        components--;
        if(size[rootParent1]<size[rootParent2])
        {
            parent[rootParent1]=rootParent2;
            size[rootParent2]+=size[rootParent1];
        }
        else
        {
            parent[rootParent2]=rootParent1;
            size[rootParent1]+=size[rootParent2];
        }
        return true;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna