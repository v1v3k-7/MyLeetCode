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
class Solution {
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
    public boolean isSymmetric(TreeNode root) 
    {
        Queue<MyNode> queue=new LinkedList<>();
        queue.offer(new MyNode(root, 0));
        int level=0;
        while(!queue.isEmpty())
        {
            int size=queue.size();
            int n=1<<level;
            int[] arr=new int[n];
            Arrays.fill(arr, -101);
            for(int i=0; i<size; i++)
            {
                MyNode current=queue.poll();
                arr[current.index-(n-1)]=current.node.val;
                if(current.node.left!=null) queue.offer(new MyNode(current.node.left, 2*current.index+1));
                if(current.node.right!=null) queue.offer(new MyNode(current.node.right, 2*current.index+2));
            }
            level++;
            int li=0, hi=n-1;
            while(li<hi)
            {
                if(arr[li]!=arr[hi]) return false;
                li++;
                hi--;
            }
        }
        return true;
    }
}