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
    public void flatten(TreeNode root) 
    {
        flattenBT(root);
    }
    public TreeNode flattenBT(TreeNode root) 
    {
        if(root==null) return null;
        TreeNode head=root;
        TreeNode rightNode=head.right;
        head.right=flattenBT(root.left);
        head.left=null;
        TreeNode temp=head;
        while(temp.right!=null) temp=temp.right;
        temp.right=flattenBT(rightNode);
        return head;
    }
}