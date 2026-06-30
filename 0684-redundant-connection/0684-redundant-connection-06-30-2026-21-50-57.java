class Solution {
    public int[] findRedundantConnection(int[][] edges) 
    {
        int totalEdge=edges.length;
        int[] res=new int[2];
        DisjointSet dsu=new DisjointSet(totalEdge);
        for(int[] edge: edges)
        {
            if(!dsu.unionBySize(edge[0]-1, edge[1]-1))
            {
                res=edge;
            }
        }
        return res;
    }
}

public class DisjointSet
{
    int[] parent, size;
    int components;
    public DisjointSet(int nodes)
    {
        this.parent=new int[nodes];
        this.size=new int[nodes];
        this.components=nodes;
        for(int i=0;i<nodes;i++)
        {
            parent[i]=i;
            size[i]=1;
        }
    }

    public int findRootParent(int node)
    {
        if(node==parent[node]) return node;
        parent[node]=findRootParent(parent[node]);
        return parent[node];
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