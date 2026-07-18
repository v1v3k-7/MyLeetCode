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
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) 
    {
        solve(root);
        return maxSum;
    }
    private int solve(TreeNode root)
    {
        if(root==null) return 0;
        int left=solve(root.left);
        int right=solve(root.right);

        int case1=left+right+root.val;
        int case2=Math.max(left, right)+root.val;
        int case3=root.val;

        maxSum=Math.max(Math.max(maxSum, case1), Math.max(case2, case3));

        return Math.max(case2,case3);
    }
}