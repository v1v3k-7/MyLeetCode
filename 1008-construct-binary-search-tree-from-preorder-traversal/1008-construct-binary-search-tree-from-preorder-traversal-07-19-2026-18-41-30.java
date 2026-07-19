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
        return solve(0, preorder.length-1, preorder);
    }
    private TreeNode solve(int low, int high, int[] preorder)
    {
        if(low>high) return null;
        TreeNode root=new TreeNode(preorder[low]);
        if(low==high) return root; //single element;

        int i=low+1;
        while(i<preorder.length && preorder[i]<root.val) i++;

        root.left=solve(low+1, i-1, preorder);
        root.right=solve(i, high, preorder);

        return root;
    }
}