# [Infix to Postfix](https://www.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1)
## Medium
You are given a string s representing an infix expression. Convert this infix expression to a postfix expression.

Infix expression: The expression of the form a op b. When an operator is in between every pair of operands.
Postfix expression: The expression of the form a b op. When an operator is followed for every pair of operands.

Note:&nbsp;The precedence order is as follows: (^) has the highest precedence and is evaluated from right to left, (* and /) come next with left to right associativity, and (+ and -) have the lowest precedence with left to right associativity.
Examples :
Input: s = "a*(b+c)/d"
Output: abc+*d/
Explanation: The expression is a*(b+c)/d. First, inside the brackets, b+c becomes bc+. Now the expression looks like a*(bc+)/d. Next, multiply a with (bc+), so it becomes abc+* . Finally, divide this result by d, so it becomes abc+*d/.

Input: s = "a+b*c+d"
Output: abc*+d+
Explanation: The expression a+b*c+d is converted by first doing b*c -&gt; bc*, then adding a -&gt; abc*+, and finally adding d -&gt; abc*+d+.
Input: s = "(a+b)*(c+d)"
Output: ab+cd+*Explanation: The expression (a+b)*(c+d) is converted by first doing (a+b) -&gt; ab+, then doing (c+d) -&gt; cd+, and finally the expression ab+*cd+ becomes ab+cd+*. 
Constraints:1 ≤ s.length ≤ 5*103s[i] can be an operand (a–z, A–Z, 0–9), an operator (+, -, *, /, ^) or a parenthesis ((, ))