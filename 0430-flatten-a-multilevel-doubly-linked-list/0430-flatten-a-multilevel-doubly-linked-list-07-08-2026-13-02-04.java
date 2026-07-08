/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) 
    {
        if(head==null) return null;
        Node next=flatten(head.next);
        Node bottom=flatten(head.child);
        if(bottom!=null)
        {
            head.next=bottom;
            bottom.prev=head;
            Node temp=head;
            while(temp.next!=null) temp=temp.next;
            temp.next=next;
            if(next!=null) next.prev=temp;
        }
        else
        {
            head.next=next;
            if(next!=null) next.prev=head;
        }
        head.child=null;
        return head; 
    }
}