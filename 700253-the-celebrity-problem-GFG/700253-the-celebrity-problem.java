class Solution {
    public int celebrity(int mat[][]) 
    {
        int n=mat.length;
        Stack<Integer> stack=new Stack<>();
        for(int i=0; i<n; i++) stack.push(i);
        
        while(stack.size()>1)
        {
            int i=stack.pop();
            int j=stack.pop();
            if(mat[i][j]==1) stack.push(j);
            else stack.push(i);
        }
        int celeb=stack.pop();
        for(int i=0; i<n; i++)
        {
            if(i==celeb) continue;
            if(mat[i][celeb]!=1) return -1;
            if(mat[celeb][i]!=0) return -1;
        }
        return celeb;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna