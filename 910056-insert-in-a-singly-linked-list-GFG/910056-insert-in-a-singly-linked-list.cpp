/* Structure of Linked List Node
class Node {
  public:
    int data;
    Node* next;
    Node(int data) {
        this->data = data;
        this->next = nullptr;
    }
}; */

class Solution {
  public:
    Node* insertPos(Node* head, int pos, int val) {
        Node* n=new Node(val);
        if(pos==1)
        {
            n->next=head;
            return n;
        }
        Node* temp=head;
        for(int i=1; i<pos-1 && temp!=nullptr; i++) temp=temp->next;
        if(temp==nullptr) return head; //pos is greater than no of nodes
        n->next=temp->next;
        temp->next=n;
        return head;
    }
};

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna