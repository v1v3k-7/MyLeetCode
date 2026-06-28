# [Directed Graph Cycle](https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1)
## Medium
Given a Directed Graph with&nbsp;V&nbsp;vertices (Numbered from&nbsp;0&nbsp;to&nbsp;V-1) and&nbsp;E&nbsp;edges, check whether it contains any&nbsp;cycle&nbsp;or not.The graph is&nbsp;represented as a 2D vector&nbsp;edges[][], where each entry&nbsp;edges[i] = [u, v] denotes an edge from vertex u&nbsp;to&nbsp;v.
Examples:
Input: V = 4, edges[][] = [[0, 1], [1, 2], [2, 0], [2, 3]]



Output: true
Explanation: The diagram clearly shows a cycle 0 → 1 → 2 → 0
Input: V = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]]
Output: false
Explanation: no cycle in the graph
Constraints:1 ≤ V ≤ 1050 ≤ E ≤ 1050 ≤ edges[i][0], edges[i][1] &lt; V