/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution 
{
    class MyNode
    {
        TreeNode node;
        int index;
        MyNode(TreeNode node, int index)
        {
            this.node=node;
            this.index=index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) 
    {
        Deque<MyNode> deque=new ArrayDeque<>();
        deque.offerLast(new MyNode(root, 0));
        int maxWidth=0;
        while(!deque.isEmpty())
        {
            maxWidth=Math.max(maxWidth, deque.peekLast().index-deque.peekFirst().index + 1);
            int size=deque.size();
            for(int i=0; i<size; i++)
            {
                MyNode node=deque.pollFirst();
                if(node.node.left!=null) deque.offerLast(new MyNode(node.node.left, 2*node.index+1));
                if(node.node.right!=null) deque.offerLast(new MyNode(node.node.right, 2*node.index+2));
            }
        }
        return maxWidth;
    }
}