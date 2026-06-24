# [LRU Cache](https://www.geeksforgeeks.org/problems/lru-cache/1)
## Hard
Design a data structure that works like a LRU Cache. Here&nbsp;cap&nbsp;denotes&nbsp;the capacity of the cache and&nbsp;Q&nbsp;denotes the number of queries. Query can be&nbsp;of two types:

PUT&nbsp;x&nbsp;y: sets the value of the key&nbsp;x&nbsp;with value&nbsp;y
GET&nbsp;x: gets the value of key x&nbsp;if present else returns&nbsp;-1.

The LRUCache class has two methods&nbsp;get() and&nbsp;put() which are defined as follows.

get(key): returns the value of the key if it&nbsp;already exists in the cache otherwise returns&nbsp;-1.
put(key, value): if the key is already present, update its value. If not present, add the key-value pair to the cache. If the cache reaches its capacity it should remove the least recently used item before inserting the new item.
In the&nbsp;constructor&nbsp;of the class the capacity of the cache should be initialized.

Examples:
Input: cap = 2, Q = 2, Queries = [["PUT", 1, 2], ["GET", 1]]
Output: [2]
Explanation: Cache Size = 2
["PUT", 1, 2] will insert the key-value pair (1, 2) in the cache,
["GET", 1] will print the value corresponding to Key 1, ie 2.
Input: cap = 2, Q = 8, Queries = [["PUT", 1, 2], ["PUT", 2, 3], ["PUT", 1, 5], ["PUT", 4, 5], ["PUT", 6, 7], ["GET", 4], ["PUT", 1, 2], ["GET", 3]]Output: [5, -1]
Explanation: Cache Size = 2
["PUT", 1, 2] will insert the pair (1,2) in the cache.
["PUT", 2, 3] will insert the pair (2,3) in the cache: 1-&gt;2, 2-&gt;3(the most recently used one is kept at the rightmost position)&nbsp;
["PUT", 1, 5] will replace the value of 1 from 2 to 5 : 2 -&gt; 3, 1 -&gt; 5
["PUT", 4, 5] : 1 -&gt; 5, 4 -&gt; 5 (Cache size is 2, hence we delete the least recently used key-value pair)
["PUT", 6, 7] : 4 -&gt; 5, 6 -&gt; 7&nbsp;
["GET", 4] : Prints 5 (The cache now looks like 6 -&gt; 7, 4-&gt;5)
["PUT", 1, 2] : 4 -&gt; 5, 1 -&gt; 2  (Cache size is 2, hence we delete the least recently used key-value pair)
["GET", 3] : No key value pair having key = 3. Hence, -1 is printed.
Constraints:1 ≤ cap ≤ 1031 ≤ Q ≤ 1051 ≤ x, y ≤ 104