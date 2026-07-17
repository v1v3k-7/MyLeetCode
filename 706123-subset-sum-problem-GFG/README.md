# [Subset Sum Problem](https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1)
## Medium
Given an array of positive integers arr[] and a value sum, determine if there is a subset of arr[] with sum equal to given sum.&nbsp;
Examples:
Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 9Output: true&nbsp;
Explanation: Here there exists a subset with target sum = 9, 4+3+2 = 9.

Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 30
Output: false
Explanation: There is no subset with target sum 30.
Input: arr[] = [1, 2, 3], sum = 6
Output: trueExplanation: The entire array can be taken as a subset, giving 1 + 2 + 3 = 6.
Constraints:1 &lt;= arr.size() &lt;= 2001&lt;= arr[i] &lt;= 2001&lt;= sum &lt;= 104