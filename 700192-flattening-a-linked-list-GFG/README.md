# [Flattening a Linked List](https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1)
## Medium
Given a linked list containing&nbsp;n&nbsp;head nodes where every node in the linked list contains two pointers:(i)&nbsp;next&nbsp;points to the next node in the list.(ii)&nbsp;bottom&nbsp;points to a sub-linked list where the current node is the head.Each of the sub-linked lists nodes and the head nodes are sorted in ascending order based on their data. Flatten the linked list such that all the nodes appear in a single level while maintaining the sorted order.
Note:1. ↓ represents the bottom pointer and →&nbsp;represents the next pointer.2.&nbsp;The flattened list will be printed using the&nbsp;bottom pointer instead of the next pointer.
Examples:
Input:Output: 5 -&gt; 7 -&gt; 8 -&gt; 10 -&gt; 19 -&gt; 20 -&gt; 22 -&gt; 28 -&gt; 40 -&gt; 45.Explanation: Bottom pointer of 5 is pointing to 7.Bottom pointer of 7 is pointing to 8.Bottom pointer of 10 is pointing to 20 and so on.
So, after flattening the linked list the sorted list will be 5 -&gt; 7 -&gt; 8 -&gt; 10 -&gt; 19 -&gt; 20 -&gt; 22 -&gt; 28 -&gt; 40 -&gt; 45.
Input:Output: 5 -&gt; 7 -&gt; 8 -&gt; 10 -&gt; 19 -&gt; 22 -&gt; 28 -&gt; 30 -&gt; 50Explanation:Bottom pointer of 5 is pointing to 7.Bottom pointer of 7 is pointing to 8.Bottom pointer of 8 is pointing to 30 and so on.So, after flattening the linked list the sorted list will be 
5 -&gt; 7 -&gt; 8 -&gt; 10 -&gt; 19 -&gt; 22 -&gt; 28 -&gt; 30 -&gt; 50.
Constraints:0&nbsp;≤&nbsp;n ≤&nbsp;1001&nbsp;≤&nbsp;number of nodes in sub-linked list(mi)&nbsp;≤&nbsp;501&nbsp;≤&nbsp;node-&gt;data ≤&nbsp;105