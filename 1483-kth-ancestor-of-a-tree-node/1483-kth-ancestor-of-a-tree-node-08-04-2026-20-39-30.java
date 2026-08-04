class TreeAncestor 
{
    int[][] ancestor; //[i][j] -> i node k 2^jth ancestor kon sa node hai
    int cols=0;
    private int log2(int n)
    {
        return 32-Integer.numberOfLeadingZeros(n); //1-based
    }
    public TreeAncestor(int n, int[] parent) 
    {
        if(n!=0)
        {
            cols=log2(n);
            ancestor=new int[n][cols];
            for(int i=0; i<n; i++) //fill first col (power is 0, 2^0)
            {
                ancestor[i][0]=parent[i];
            }
            for(int j=1; j<cols; j++) //col -> power
            {
                for(int i=0; i<n; i++) //row -> node
                {
                    if(ancestor[i][j-1]!=-1) ancestor[i][j]=ancestor[ancestor[i][j-1]][j-1];
                    else ancestor[i][j]=-1;
                }
            }
        }
    }
    
    public int getKthAncestor(int node, int k) 
    {
        if(cols==0 || (k>=(1<<cols))) return -1;
        if(k==0) return node;
        //har set bit ka ka mamla 
        int node_=node;
        for(int j=0; j<cols; j++)
        {
            if((k & (1<<j))!=0) //set bit hai
            {
                node_=ancestor[node_][j];
                if(node_==-1) return -1;
            }
        }
        return node_;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */