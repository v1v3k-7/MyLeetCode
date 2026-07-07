/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public Node flattenBST(Node root) 
    {
        if(root==null) return null;
        
        Node head=flattenBST(root.left);
        root.left=null;
        root.right=flattenBST(root.right);
        if(head!=null)
        {
            Node temp=head;
            while(temp.right!=null) temp=temp.right;
            temp.right=root;
        }
        else
        {
            head=root;
        }
        return head;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna