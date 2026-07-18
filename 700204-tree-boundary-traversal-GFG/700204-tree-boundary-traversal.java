/* Node Structure
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    public ArrayList<Integer> boundaryTraversal(Node root) 
    {
        ArrayList<Integer> res=new ArrayList<>();
        res.add(root.data);
        leftNodes(root.left, res);
        leafNodes(root.left, res);
        leafNodes(root.right, res);
        rightNodes(root.right, res, res.size());
        return res;
        
    }
    private void leftNodes(Node root, ArrayList<Integer> res)
    {
        if(root==null || root.left==null && root.right==null) return;
        
        res.add(root.data);
        
        if(root.left!=null) leftNodes(root.left, res);
        else leftNodes(root.right, res);
    }
    private void rightNodes(Node root, ArrayList<Integer> res, int idx)
    {
        if(root==null || root.left==null && root.right==null) return;
        res.add(idx, root.data);
        
        if(root.right!=null) rightNodes(root.right, res, idx);
        else rightNodes(root.left, res, idx);
    }
    private void leafNodes(Node root, ArrayList<Integer> res)
    {
        if(root==null) return;
        if(root.left==null && root.right==null) res.add(root.data);
        leafNodes(root.left, res);
        leafNodes(root.right, res);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna