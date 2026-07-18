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
    Map<Integer, Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) 
    {
        int n=inorder.length;
        for(int i=0; i<n; i++)
        {
            map.put(inorder[i], i);
        }
        return solve(inorder, postorder, 0, n-1, 0, n-1);
    }
    private TreeNode solve(int[] inorder, int[] postorder, int iStart, int iEnd, int pStart, int pEnd)
    {
        if(iStart>iEnd || pStart>pEnd) return null;

        TreeNode root=new TreeNode(postorder[pEnd]);
        int idx=map.get(postorder[pEnd]);
        int leftSize=idx-iStart;

        root.left=solve(inorder, postorder, iStart, idx-1, pStart, pStart+leftSize-1);
        root.right=solve(inorder, postorder, idx+1, iEnd, pStart+leftSize, pEnd-1);

        return root;
    }
}