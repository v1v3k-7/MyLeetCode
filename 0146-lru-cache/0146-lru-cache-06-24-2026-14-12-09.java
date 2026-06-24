class LRUCache {
    class Node
    {
        int key, val;
        Node prev, next;
        Node(int key, int val)
        {
            this.key=key;
            this.val=val;
        }
    }
    Node head=new Node(0, -1), tail=new Node(0, -1); //dummy
    HashMap<Integer, Node> map=new HashMap<>(); //key -> Node
    int cap;
    public LRUCache(int capacity) 
    {
        cap=capacity;
        head.next=tail;
        tail.prev=head;
    }
    
    public void add(Node node)
    {
        node.next=tail;
        node.prev=tail.prev;
        node.prev.next=node;
        node.next.prev=node;
    }
    public void remove(Node node)
    {
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    public int get(int key) 
    {
        Node node=map.get(key);
        if(node==null) return -1;
        else
        {
            remove(node);
            add(node);
            return node.val;
        }
    }
    
    public void put(int key, int value) 
    {
        if(cap==0) return;
        if(map.containsKey(key))
        {
            Node node=map.get(key);
            node.val=value;
            remove(node);
            add(node);
        }
        else
        {
            if(map.size()==cap)
            {
                Node toBeDelete=head.next;
                remove(toBeDelete);
                map.remove(toBeDelete.key);
            }
            Node node=new Node(key, value);
            add(node);
            map.put(key, node);
        }
    }
}

