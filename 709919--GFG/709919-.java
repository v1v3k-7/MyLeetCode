class Solution {
    public static void reverseStack(Stack<Integer> st) 
    {
        if(st.isEmpty()) return;
        int top=st.pop();
        reverseStack(st);
        insertAtBottom(st, top);
    }
    static public void insertAtBottom(Stack<Integer> st, int num)
    {
        if(st.isEmpty())
        {
            st.push(num);
            return;
        }
        int top=st.pop();
        insertAtBottom(st, num);
        st.push(top);
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna