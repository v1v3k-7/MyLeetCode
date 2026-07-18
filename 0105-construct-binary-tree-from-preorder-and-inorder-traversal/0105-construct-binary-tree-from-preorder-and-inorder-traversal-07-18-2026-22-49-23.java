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
    HashMap<Integer, Integer> map=new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
        int n=inorder.length;
        for(int i=0; i<n; i++)
        {
            map.put(inorder[i], i);
        }
        return solve(preorder, inorder, 0, n-1, 0, n-1);
    }
    private TreeNode solve(int[] preOrder, int[] inOrder, int pStart, int pEnd, int iStart, int iEnd)
    {
        if (pStart > pEnd || iStart > iEnd) return null;

        TreeNode root=new TreeNode(preOrder[pStart]);
        int idx=map.get(preOrder[pStart]);
        int leftSize=idx-iStart;

        root.left=solve(preOrder, inOrder, pStart+1, pStart+leftSize, iStart, idx-1);
        root.right=solve(preOrder, inOrder, pStart+leftSize+1, pEnd, idx+1, iEnd);

        return root;
    }
}