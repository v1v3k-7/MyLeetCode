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
    public boolean isBalanced(TreeNode root) 
    {
        return solve(root)!=-1;
    }
    private int solve(TreeNode root) //return depth difference
    {
        if(root==null) return 0;
        int leftSubtree=solve(root.left); //return left height
        int rightSubtree=solve(root.right); //return right height
        if(leftSubtree==-1||rightSubtree==-1) return -1;
        int diff=Math.abs(leftSubtree-rightSubtree);
        if(diff>1) return -1;
        return 1+Math.max(leftSubtree, rightSubtree);
    }
}