# [Range Minimum Query](https://www.geeksforgeeks.org/problems/range-minimum-query/1)
## Medium
Given an array A[ ] and its size N your task is to complete two functions&nbsp; a constructST&nbsp; function which builds the segment tree&nbsp; and a function RMQ which finds range minimum query in a range [a,b] of the given array.

Input:
The task is to complete two functions constructST and RMQ.
The constructST function builds the segment tree and takes two arguments the array A[ ] and the size of the array N.
It returns a pointer to the first element of the segment tree array.
The RMQ function takes 4 arguments the first being the segment tree st constructed, second being the size N and then third and forth arguments are the range of query a and b. The function RMQ returns the min of the elements in the array from index range a and b. There are multiple test cases. For each test case, this method will be called individually.

Output:
The function RMQ should return the min element in the array from range a to b.

Example:

Input (To be used only for expected output) 
1
4
1 2 3 4
2
0 2 2 3
Output
1 3
Explanation
1. For query 1 ie 0 2 the element in this range are 1 2 3 
&nbsp;  and the min element is 1. 
2. For query 2 ie 2 3 the element in this range are 3 4 
&nbsp;  and the min element is 3.

Constraints:
1&lt;=T&lt;=100
1&lt;=N&lt;=10^3+1

1&lt;=A[i]&lt;=10^9
1&lt;=Q(no of queries)&lt;=10000
0&lt;=a&lt;=b
