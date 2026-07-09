class Solution 
{
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) 
    {
        DSU dsu=new DSU(n);
        for(int i=0; i<n-1; i++)
        {
            if(nums[i+1]-nums[i]<=maxDiff)
            {
                dsu.unionBySize(i, i+1);
            }
        }

        int m=queries.length;
        boolean[] res=new boolean[m];
        for(int i=0; i<m; i++)
        {
            int[] query=queries[i];
            if(dsu.isSameParent(query[0], query[1])) res[i]=true;
        }
        return res;
    }
}
class DSU
{
    int components;
    int[] parent, size;
    DSU(int n)
    {
        components=n;
        parent=new int[n];
        size=new int[n];
        for(int i=0; i<n; i++)
        {
            size[i]=1;
            parent[i]=i;
        }
    }
    int findRootParent(int node)
    {
        if(node==parent[node]) return node;
        return parent[node]=findRootParent(parent[node]);
    }
    boolean isSameParent(int node1, int node2)
    {
        int p1=findRootParent(node1);
        int p2=findRootParent(node2);
        return p1==p2;
    }

    void unionBySize(int node1, int node2)
    {
        int p1=findRootParent(node1);
        int p2=findRootParent(node2);
        if(p1==p2) return;
        components--;
        if(size[p1]<size[p2])
        {
            size[p2]+=size[p1];
            parent[p1]=p2;
        }
        else
        {
            size[p1]+=size[p2];
            parent[p2]=p1;
        }
    }
}