class Solution {
    public void floydWarshall(int[][] dist) 
    {
        int n=dist.length;
        
        for(int k=0; k<n; k++)
        {
            for(int i=0; i<n; i++)
            {
                for(int j=0; j<n; j++)
                {
                    if (dist[i][k] != (int)(1e8) && dist[k][j] != (int)(1e8)) 
                    {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        
        // for(int i=0; i<n; i++)
        // {
        //     if(dist[i][i]<0)
        //         System.out.println("Negative Cycle Detected")
        // }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna