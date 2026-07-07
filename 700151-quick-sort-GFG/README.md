# [Quick Sort](https://www.geeksforgeeks.org/problems/quick-sort/1)
## Medium
Given an array arr[], with starting index low and ending index high, complete the functions partition() and quickSort() so that the array becomes sorted in ascending order.
Examples:
Input: arr[] = [4, 1, 3, 9, 7]
Output: [1, 3, 4, 7, 9]Explanation: After sorting, all elements are arranged in ascending order.
Input: arr[] = [2, 1, 6, 10, 4, 1, 3, 9, 7]
Output: [1, 1, 2, 3, 4, 6, 7, 9, 10]Explanation: Duplicate elements (1) are retained in sorted order.
Input: arr[] = [5, 5, 5, 5]
Output: [5, 5, 5, 5]Explanation: All elements are identical, so the array remains unchanged.
Constraints:1 ≤ arr.size() ≤ 1051 ≤ arr[i] ≤ 105