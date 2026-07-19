/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root)
    {
        if(root==null) return root;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        queue.offer(null); //mark as end of level
        Node prev=null;
        while(!queue.isEmpty())
        {
            Node current=queue.poll();
            if(current!=null)
            {
                if(current.left!=null) queue.offer(current.left);
                if(current.right!=null) queue.offer(current.right);

                if(prev!=null) prev.next=current;
            }
            else
            {
                if(queue.size()==0) break;
                queue.offer(null);
            }
            prev=current;
        }
        return root;
    }
}