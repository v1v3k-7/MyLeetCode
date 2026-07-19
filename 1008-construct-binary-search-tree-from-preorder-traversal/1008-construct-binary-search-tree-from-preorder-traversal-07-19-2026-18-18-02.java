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
    public TreeNode bstFromPreorder(int[] preorder) 
    {
        TreeNode root=null;
        for(int no: preorder)
        {
            root=solve(root, no);
        }
        return root;
    }
    private TreeNode solve(TreeNode root, int no)
    {
        if(root==null) return new TreeNode(no);
        if(root.val>no) root.left=solve(root.left, no);
        else root.right=solve(root.right, no);
        return root;
    }
}