// this code is of striever. just to test time in ms

class MinStack {
    // Initialize a stack
    private Stack<int[]> st;

    // Empty Constructor
    public MinStack() {
        st = new Stack<>();
    }

    // Method to push a value in stack
    public void push(int value) {
        // If stack is empty
        if (st.isEmpty()) {
            // Push current value as minimum
            st.push(new int[]{value, value});
            return;
        }

        // Update the current minimum
        int mini = Math.min(getMin(), value);

        // Add the pair to the stack
        st.push(new int[]{value, mini});
    }

    // Method to pop a value from stack
    public void pop() {
        // Using in-built pop method
        st.pop();
    }

    // Method to get the top of stack
    public int top() {
        // Return the top value
        return st.peek()[0];
    }

    // Method to get the minimum in stack
    public int getMin() {
        // Return the minimum
        return st.peek()[1];
    }
}
