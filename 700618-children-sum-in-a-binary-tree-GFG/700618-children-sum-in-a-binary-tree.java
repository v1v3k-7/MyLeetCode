/* Node Structure
class Node{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
} */
class Solution {
    public boolean isSumProperty(Node root) 
    {
        if(root==null || root.left==null && root.right==null) return true;
        
        int leftVal=(root.left==null)?0:root.left.data;
        int rightVal=(root.right==null)?0:root.right.data;
        
        if(root.data!=leftVal+rightVal) return false;
        
        if (isSumProperty(root.left) && isSumProperty(root.right)) return true;
        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna