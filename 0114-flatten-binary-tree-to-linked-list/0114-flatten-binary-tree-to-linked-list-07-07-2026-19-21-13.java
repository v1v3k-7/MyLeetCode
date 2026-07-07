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
        if(root==null) return;

        TreeNode left=flattenBT(root.left);
        TreeNode right=flattenBT(root.right);

        root.left=null;

        if(left==null) root.right=right;
        else
        {
            root.right=left;
            while(root.right!=null) root=root.right;
            root.right=right;
        }
    }
    public TreeNode flattenBT(TreeNode root) 
    {
        if(root==null) return null;

        TreeNode left=flattenBT(root.left);
        TreeNode right=flattenBT(root.right);
        root.left=null;
        if(left!=null && right!=null)
        {
            root.right=left;
            TreeNode temp=left;
            while(temp.right!=null) temp=temp.right;
            temp.right=right;
        }
        else if(left!=null)
        {
            root.right=left;
        }
        else
        {
            root.right=right;
        }
        return root;
    }
}