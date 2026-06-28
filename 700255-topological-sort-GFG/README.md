# [Topological Sort](https://www.geeksforgeeks.org/problems/topological-sort/1)
## Medium
Given a&nbsp;Directed Acyclic Graph (DAG)&nbsp;of&nbsp;V&nbsp;(0 to V-1)&nbsp;vertices and&nbsp;E&nbsp;edges represented as a 2D list of&nbsp;edges[][], where each entry&nbsp;edges[i] = [u, v] denotes a&nbsp;directed&nbsp;edge&nbsp;u -&gt; v. Return the topological sort&nbsp;for the given graph.
Topological sorting for&nbsp;Directed Acyclic Graph (DAG)&nbsp;is a linear ordering of vertices such that for every directed edge&nbsp;u&nbsp;-&gt;&nbsp;v, vertex&nbsp;u&nbsp;comes before&nbsp;v&nbsp;in the ordering.
Note:&nbsp;As there are multiple Topological orders possible, you may return any of them. If your returned Topological sort is correct then the output will be&nbsp;true&nbsp;else&nbsp;false.
Examples:
Input: V = 4, E = 3, edges[][] = [[3, 0], [1, 0], [2, 0]]Output: trueExplanation: The output true denotes that the order is valid. Few valid Topological orders for the given graph are:
[3, 2, 1, 0][1, 2, 3, 0][2, 3, 1, 0]
Input: V = 6, E = 6, edges[][] = [[1, 3], [2, 3], [4, 1], [4, 0], [5, 0], [5, 2]]Output: true
Explanation: The output true denotes that the order is valid. Few valid Topological orders for the graph are:[4, 5, 0, 1, 2, 3][5, 2, 4, 0, 1, 3]
Constraints:2&nbsp;&nbsp;≤&nbsp;&nbsp;V&nbsp;&nbsp;≤&nbsp; 5 x 1031&nbsp;&nbsp;≤&nbsp;&nbsp;E =&nbsp;edges.size()&nbsp;&nbsp;≤&nbsp; min[105, (V * (V - 1)) / 2]0 ≤ edges[i][0], edges[i][1] &lt; V