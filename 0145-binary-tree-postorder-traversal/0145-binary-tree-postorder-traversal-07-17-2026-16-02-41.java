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
    public List<Integer> postorderTraversal(TreeNode root) 
    {
        List<Integer> res=new ArrayList<>();
        TreeNode node=root;
        Stack<TreeNode> st=new Stack<>();
        while(node!=null || !st.isEmpty())
        {
            if(node!=null) 
            {
                st.push(node);
                node=node.left;
            }
            else if(st.peek().right!=null)
            {
                node=st.peek().right;
            }
            else
            {
                TreeNode temp=st.pop();
                res.add(temp.val);
                while(!st.isEmpty() && temp==st.peek().right)
                {
                    temp=st.pop();
                    res.add(temp.val);
                }
            }
        }
        return res;
    }
}