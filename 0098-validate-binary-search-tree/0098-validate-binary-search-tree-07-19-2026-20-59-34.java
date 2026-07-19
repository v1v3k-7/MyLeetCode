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
    public boolean isValidBST(TreeNode root) 
    {
        return solve(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean solve(TreeNode root, long leftMin, long rightMax)
    {
        if(root==null) return true;
        if(root.val<=leftMin || root.val>=rightMax) return false;

        if(solve(root.left, leftMin, root.val) && solve(root.right, root.val, rightMax)) return true;
        else return false;
    }
}