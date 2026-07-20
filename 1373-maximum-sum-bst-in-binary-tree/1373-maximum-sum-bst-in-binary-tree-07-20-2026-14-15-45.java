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
    int ans=0;
    public int maxSumBST(TreeNode root) 
    {
        dfs(root); //ans -> [min, max, sum]
        return ans;
    }
    //arr -> min, max, sum
    private int[] dfs(TreeNode root)
    {
        if(root==null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};

        int leftTree[] = dfs(root.left);
        int rightTree[] = dfs(root.right);

        if(root.val > leftTree[1] && root.val < rightTree[0])
        {
            int sum=leftTree[2] + rightTree[2] + root.val;
            ans=Math.max(sum, ans);
            int maxVal=Math.max(root.val, rightTree[1]);
            int minVal=Math.min(root.val, leftTree[0]);
            return new int[]{minVal, maxVal, sum};
        }
        else
        {
            int sum=Math.max(leftTree[2], rightTree[2]);
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, sum};
        }
    }
}