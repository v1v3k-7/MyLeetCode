class LFUCache 
{
    class Node
    {
        int key, val, count;
        Node prev, next;
        Node(int key, int val)
        {
            this.key=key;
            this.val=val;
        }
        Node(int key, int val, int count)
        {
            this.key=key;
            this.val=val;
            this.count=count;
        }
    }

    Node head=new Node(0, -1, 0), tail=new Node(0, -1, 0); //dummy
    int cap;
    HashMap<Integer, Node> map=new HashMap<>();
    public LFUCache(int capacity) 
    {
        cap=capacity;
        head.next=tail;
        tail.prev=head;
    }
    
    public void deleteNode(Node node)
    {
        Node delPrev=node.prev;
        Node delNext=node.next;
        delPrev.next=delNext;
        delNext.prev=delPrev;
    }

    public void putAtPos(Node node)
    {
        Node temp=tail.prev;
        while(temp.count>node.count) temp=temp.prev;
        node.next=temp.next;
        node.prev=temp;
        temp.next=node;
        node.next.prev=node;
    }

    public int get(int key) 
    {
        Node node=map.get(key);
        if(node==null) return -1;
        else
        {
            node.count++;
            deleteNode(node);
            putAtPos(node);
            return node.val;
        }
    }
    
    public void put(int key, int value) 
    {
        if(cap==0) return;
        if(map.containsKey(key))
        {
            Node node=map.get(key);
            node.count++;
            node.val=value;
            deleteNode(node);
            putAtPos(node);
        }
        else
        {
            if(map.size()==cap)
            {
                Node toBeDelete=head.next;
                deleteNode(toBeDelete);
                map.remove(toBeDelete.key);
            }
            Node node=new Node(key, value, 1);
            putAtPos(node);
            map.put(key, node);
        }
    }
}

