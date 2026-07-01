class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(n>connections.length+1) return -1;

        DisjointSet dsu=new DisjointSet(n);
        int extraCable=0;
        for(int[] edge: connections)
        {
            if(!dsu.unionBySize(edge[0], edge[1]))
            {
                extraCable++;
            }
        }
        int need=dsu.components-1;

        return need;
    }
}
class DisjointSet
{
    int[] parent, size;
    int components;
    DisjointSet(int nodes)
    {
        this.parent=new int[nodes];
        this.size=new int[nodes];
        this.components=nodes;
        for(int i=0; i<nodes; i++)
        {
            this.size[i]=1;
            this.parent[i]=i;
        }
    }
    int findRootParent(int node)
    {
        if(node==parent[node]) return node;
        parent[node]=findRootParent(parent[node]);
        return parent[node];
    }
    boolean unionBySize(int node1, int node2)
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