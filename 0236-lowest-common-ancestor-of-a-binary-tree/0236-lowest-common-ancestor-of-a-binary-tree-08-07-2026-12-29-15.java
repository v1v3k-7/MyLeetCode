/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //Solving using BINARY LIFTING
class Solution 
{
    HashMap<TreeNode, Integer> id=new HashMap<>();
    List<TreeNode> nodes=new ArrayList<>();
    int ancestor[][];
    int n;
    int cols;
    int[] parent, depth;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        assignID(root);

        ancestor=new int[n][cols];
        for(int i=0; i<n; i++) ancestor[i][0]=parent[i]; //fill first column

        for(int j=1; j<cols; j++)
        {
            for(int i=0; i<n; i++)
            {
                if(ancestor[i][j-1]!=-1) ancestor[i][j]=ancestor[ancestor[i][j-1]][j-1];
                else ancestor[i][j]=-1;
            }
        }

        //now balance the depth;  
        int u=id.get(p), v=id.get(q);
        if(depth[u]<depth[v]) {int temp=u; u=v; v=temp;}
        int diff=depth[u]-depth[v];
        for(int j=0; j<cols; j++)
        {
            if((diff & (1<<j))!=0) //set bit hai
            {
                u=ancestor[u][j];
            }
        }
        if(u==v) return nodes.get(u);  
        //now u and v (id of p & q) are at same level
        for(int j=cols-1; j>=0; j--)
        {
            if(ancestor[u][j]!=ancestor[v][j])
            {
                u=ancestor[u][j];
                v=ancestor[v][j];
            }
        }
        return nodes.get(ancestor[u][0]);
    }
    private void assignID(TreeNode root)
    {
        //assign id to each node 0, 1, 2, ....... and store in hashmap to get id from node, also make a list of nodes to get node from id
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int cnt=0;
        while(!queue.isEmpty())
        {
            TreeNode cur=queue.poll();
            id.put(cur, cnt);
            nodes.add(cur);
            if(cur.left!=null) queue.offer(cur.left);
            if(cur.right!=null) queue.offer(cur.right);
            cnt++;
        }
        n=cnt;
        cols=32-Integer.numberOfLeadingZeros(n);


        //make parent array like id=1 wale node k parent ka id kya hai and id=1 wale node ka depth kya hai
        parent=new int[n];
        depth=new int[n];
        Arrays.fill(parent, -1);
        parent[id.get(root)]=-1;
        depth[id.get(root)]=0;

        Queue<TreeNode> bfs=new LinkedList<>();
        bfs.offer(root);
        while(!bfs.isEmpty())
        {
            TreeNode cur=bfs.poll();
            int curId=id.get(cur);
            if(cur.left!=null)
            {
                bfs.offer(cur.left);
                int leftId=id.get(cur.left);
                parent[leftId]=curId;
                depth[leftId]=depth[curId]+1;
            }
            if(cur.right!=null)
            {
                bfs.offer(cur.right);
                int rightId=id.get(cur.right);
                parent[rightId]=curId;
                depth[rightId]=depth[curId]+1;
            }
        }
    }
}