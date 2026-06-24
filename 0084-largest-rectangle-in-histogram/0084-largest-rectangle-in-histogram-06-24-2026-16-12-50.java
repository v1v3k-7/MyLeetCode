class Solution 
{
    public int largestRectangleArea(int[] heights) 
    {
        int n=heights.length;
        int maxArea=0;
        // Stack<Integer> st=new Stack<>();
        int[] arr=new int[n+1]; //just implement stack using Array 
        int index=-1;
        for(int i=0; i<n+1; i++) // n+1 bcz last me 0 le lenge jo sbko uda dega
        {
            int num=(i==n)?0:heights[i];
            while(index!=-1 && heights[arr[index]]>=num)
            {
                // int h=heights[st.pop()];
                int h=heights[arr[index--]];
                int ns=i;
                // int ps=(st.isEmpty())?-1:st.peek();
                int ps=(index==-1)?-1:arr[index];
                int w=ns-ps-1;
                maxArea=Math.max(maxArea, h*w);
            }
            // st.push(i);
            arr[++index]=i;
        }
        return maxArea;
    }
}