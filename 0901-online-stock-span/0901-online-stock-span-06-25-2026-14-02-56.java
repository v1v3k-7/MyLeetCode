class StockSpanner 
{
    //used array instead of stack (implemented stack using array)

    // Stack<int[]> stack;
    int[][] stack=new int[1000][2];
    int idx=-1;
    public StockSpanner() 
    {
        // stack=new Stack<>();
    }
    
    public int next(int price) 
    {
        int ans=1;
        while(idx!=-1 && stack[idx][0]<=price) ans+=stack[idx--][1];
        stack[++idx]=new int[]{price, ans};
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */