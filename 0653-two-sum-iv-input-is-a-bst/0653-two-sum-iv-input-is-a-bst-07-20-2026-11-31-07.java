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
    public boolean findTarget(TreeNode root, int k) 
    {
        HashSet<Integer> set=new HashSet<>();
        return solve(root, k, set);
    }
    private boolean solve(TreeNode root, int k, HashSet<Integer> set)
    {
        if(root==null) return false;
        if(set.contains(k-root.val)) return true;
        else set.add(root.val);
        
        boolean left=solve(root.left, k, set);
        if(left) return true;
        boolean right=solve(root.right, k, set);
        return right;
    }
}