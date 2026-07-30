class Solution {
    public static String infixToPostfix(String s) 
    {
        Stack<Character> stack=new Stack<>();
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<n; i++)
        {
            char ch=s.charAt(i);
            if((ch>='a'&&ch<='z') || (ch>='A'&&ch<='Z') || (ch>='0'&&ch<='9')) sb.append(ch);
            else if(ch=='(') stack.push(ch);
            else if(ch==')')
            {
                while(!stack.isEmpty() && stack.peek()!='(')  sb.append(stack.pop());
                stack.pop();
            }
            else //operator case
            {
                while(!stack.isEmpty() && stack.peek() != '(' &&
                    ( prec(ch)<prec(stack.peek()) || (prec(ch)==prec(stack.peek()) && !rightAssociativity(ch)) )
                    )
                    {
                        sb.append(stack.pop());
                    }
                stack.push(ch);
            }
        }
        while(!stack.isEmpty()) sb.append(stack.pop());
        return sb.toString();
    }
    
    public static int prec(char ch)
    {
        if(ch=='^') return 3;
        else if(ch=='/'||ch=='*') return 2;
        else if(ch=='+'||ch=='-') return 1;
        else return -1;
    }
    public static boolean rightAssociativity(char ch)
    {
        return ch=='^';
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna