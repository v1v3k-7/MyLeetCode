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
class BSTIterator {
    int index=0;
    int capacity;
    List<Integer> list=new ArrayList<>();
    public BSTIterator(TreeNode root) 
    {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode current=root;
        while(!stack.isEmpty() || current!=null)
        {
            if(current!=null)
            {
                stack.push(current);
                current=current.left;
            }
            else
            {
                TreeNode temp=stack.pop();
                list.add(temp.val);
                current=temp.right;
            }
        }
        this.capacity=list.size();
    }
    
    public int next() 
    {
        int val=list.get(index);
        index++;
        return val;
    }
    
    public boolean hasNext() 
    {
        return index<capacity;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */