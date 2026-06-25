class MinStack {
    Stack<Integer> minSt, stack;
    public MinStack() 
    {
        minSt=new Stack<>();
        stack=new Stack<>();
    }
    
    public void push(int value) 
    {
        stack.push(value);
        if(minSt.isEmpty() || minSt.peek()>=value) minSt.push(value);
    }
    
    public void pop() 
    {
        int val=stack.pop();
        if(val==minSt.peek()) minSt.pop();
    }
    
    public int top() 
    {
        return stack.peek();
    }
    
    public int getMin() 
    {
        return minSt.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */