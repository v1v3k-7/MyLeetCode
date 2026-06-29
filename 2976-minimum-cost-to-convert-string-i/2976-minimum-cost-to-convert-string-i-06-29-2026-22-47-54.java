class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) 
    {
        int n=original.length;

        //first make a array for like a->b me change krne k lie mini cost and all and use floyd warshall algorithm for that;

        long dist[][]=new long[26][26]; //mini cost to convert 
        for(int i=0; i<26; i++)
        {
            Arrays.fill(dist[i], Long.MAX_VALUE);
            dist[i][i] = 0;
        }

        for(int i=0; i<n; i++)
        {
            int u=original[i]-'a';
            int v=changed[i]-'a';
            dist[u][v] = Math.min(dist[u][v], (long) cost[i]);
        }
        for(int k=0; k<26; k++) //via
        {
            for(int i=0; i<26; i++)
            {
                for(int j=0; j<26; j++)
                {
                    if(dist[i][k]!=Long.MAX_VALUE && dist[k][j]!=Long.MAX_VALUE)
                    {
                        dist[i][j]=Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                    }
                }
            }
        }
        //now dist contains minimum cost to changed characters

        long rate=0;
        int len=source.length();
        for(int i=0; i<len; i++)
        {
            int u=source.charAt(i)-'a';
            int v=target.charAt(i)-'a';
            if(u!=v)
            {
                long c=dist[u][v];
                if(c==Long.MAX_VALUE) return -1L;
                rate+=c;
            }
        }
        return rate;

    }
}