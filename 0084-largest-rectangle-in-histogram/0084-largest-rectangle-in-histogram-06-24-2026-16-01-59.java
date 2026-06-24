class Solution 
{
    public int largestRectangleArea(int[] heights) 
    {
        int n=heights.length;
        int maxArea=0;
        Stack<Integer> st=new Stack<>();
        for(int i=0; i<n+1; i++) // n+1 bcz last me 0 le lenge jo sbko uda dega
        {
            int num=(i==n)?0:heights[i];
            while(!st.isEmpty() && heights[st.peek()]>num)
            {
                int h=heights[st.pop()];
                int ns=i;
                int ps=(st.isEmpty())?-1:st.peek();
                int w=ns-ps-1;
                maxArea=Math.max(maxArea, h*w);
            }
            st.push(i);
        }
        return maxArea;
    }
}