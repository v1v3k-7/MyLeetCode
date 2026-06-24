class Solution 
{
    public int[] nextSmaller(int[] heights)
    {
        int n=heights.length;
        int[] ans=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1; i>=0; i--)
        {
            int num=heights[i];
            while(!st.isEmpty() && heights[st.peek()]>=num) st.pop();
            ans[i]=(st.isEmpty())?n:st.peek();
            st.push(i);
        }
        return ans;
    }
    public int[] previousSmaller(int[] heights)
    {
        int n=heights.length;
        int[] ans=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0; i<n; i++)
        {
            int num=heights[i];
            while(!st.isEmpty() && heights[st.peek()]>=num) st.pop();
            ans[i]=(st.isEmpty())?-1:st.peek();
            st.push(i);
        }
        return ans;
    }
    public int largestRectangleArea(int[] heights) 
    {
        int[] ns=nextSmaller(heights);
        int[] ps=previousSmaller(heights);
        int maxArea=Integer.MIN_VALUE;
        for(int i=0; i<heights.length; i++)
        {
            int w=ns[i]-ps[i]-1;
            int h=heights[i];
            maxArea=Math.max(maxArea, w*h);
        }
        return maxArea;
    }
}