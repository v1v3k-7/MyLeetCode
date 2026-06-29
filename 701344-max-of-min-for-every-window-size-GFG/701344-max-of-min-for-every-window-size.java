class Solution 
{
    public ArrayList<Integer> maxOfMins(int[] arr) 
    {
        int n=arr.length;
        int[] ans=new int[n];
        Arrays.fill(ans, Integer.MIN_VALUE);
        Stack<Integer> stack=new Stack<>(); //store index;
        for(int i=0; i<=n; i++)
        {
            int no=(i==n)?Integer.MIN_VALUE:arr[i];
            while(!stack.isEmpty() && arr[stack.peek()]>=no)
            {
                int idx=stack.pop();
                int ns=i;
                int ps=(stack.isEmpty())?-1:stack.peek();
                int len=ns-ps-1; //len=window;
                ans[len-1]=Math.max(ans[len-1], arr[idx]);
            }
            if (i < n) stack.push(i);
        }
        for(int i=n-2; i>=0; i--)
        {
             ans[i] = Math.max(ans[i], ans[i + 1]);
        }
        ArrayList<Integer> res = new ArrayList<>();

        for (int x : ans) {
            res.add(x);
        }
        return res;
        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna