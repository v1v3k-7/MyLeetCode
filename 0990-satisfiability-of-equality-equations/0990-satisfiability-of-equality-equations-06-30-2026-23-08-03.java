class Solution {
    public boolean equationsPossible(String[] equations) 
    {
        DisjointSet dsu=new DisjointSet(26);
        ArrayList<String> notEqual=new ArrayList<>();
        for(String s: equations)
        {
            int x=s.charAt(0)-'a';
            int y=s.charAt(3)-'a';
            if(s.charAt(1)=='=')
            {
                dsu.unionBySize(x, y);
            }
            else
            {
                notEqual.add(s);
            }
        }

        for(String s: notEqual)
        {
            int x=s.charAt(0)-'a';
            int y=s.charAt(3)-'a';

            if(dsu.findRootParent(x)==dsu.findRootParent(y)) return false;
        }
        return true;
    }
}
class DisjointSet
{
    int[] size, parent;
    int components;
    DisjointSet(int nodes)
    {
        this.components=nodes;
        this.size=new int[nodes];
        this.parent=new int[nodes];
        for(int i=0; i<nodes; i++)
        {
            size[i]=1;
            parent[i]=i;
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