class LRUCache {

    static class Node
    {
        int key;
        int val;
        Node next;
        Node prev;
        Node(int key, int val)
        {
            this.key=key;
            this.val=val;
        }
    }
    
    static Node head, tail; //dummy;
    static int cap;
    static HashMap<Integer, Node> map; //key->Node;
    
    LRUCache(int cap) 
    {
        head=new Node(0, -1);
        tail=new Node(0, -1);
        map=new HashMap<>();
        this.cap=cap;
        head.next=tail;
        tail.prev=head;
    }
    
    public static void deleteNode(Node node) //delete from head k pass;
    {
        Node delPrev=node.prev;
        Node delNext=node.next;
        delPrev.next=delNext;
        delNext.prev=delPrev;
    }
    public static void addNode(Node node) //add at tail k pass
    {
        Node tailPrev=tail.prev;
        
        tailPrev.next=node;
        node.prev=tailPrev;
        
        node.next=tail;
        tail.prev=node;
    }
    public static int get(int key) 
    {
        Node node=map.get(key);
        if(node==null) return -1;
        else
        {
            deleteNode(node);
            addNode(node);
            return node.val;
        }
    }

        
    public static void put(int key, int value) 
    {
        if(cap == 0) return;
        if(map.containsKey(key))
        {
            Node node=map.get(key);
            node.val=value;
            deleteNode(node);
            addNode(node);
        }
        else
        {
            if(map.size()==cap)
            {
                Node toBeDelete=head.next;
                deleteNode(toBeDelete);
                map.remove(toBeDelete.key);
            }
            Node node=new Node(key, value);
            addNode(node);
            map.put(key, node);
            
        }
    }
    
    
}



// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna