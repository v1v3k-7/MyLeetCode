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
            count=1;
        }
    }
    class DLL
    {
        int size;
        Node head=new Node(0, -1), tail=new Node(0, -1); //dummy
        DLL()
        {
            head.next=tail;
            tail.prev=head;
            size=0;
        }
        void addLast(Node node)
        {
            size++;
            node.prev=tail.prev;
            node.next=tail;
            node.prev.next=node;
            tail.prev=node;
        }
        void remove(Node node)
        {
            if(size==0) return;
            size--;
            node.prev.next=node.next;
            node.next.prev=node.prev;
        }
        Node removeFirst()
        {
            if(size==0) return null;
            Node node=head.next;
            remove(node);
            return node;
        }
    }

    int cap;
    int minFreq;
    HashMap<Integer, Node> keyMap=new HashMap<>();
    HashMap<Integer, DLL> freqMap=new HashMap<>();
    public LFUCache(int capacity) 
    {
        cap=capacity;
    }
    
    public void update(Node node)
    {
        int freq=node.count;
        DLL list1=freqMap.get(freq);
        list1.remove(node);
        if(list1.size==0) 
        {
            if(freq==minFreq) minFreq++;
            freqMap.remove(freq);
        }

        node.count++;
        freq++;
        freqMap.putIfAbsent(freq, new DLL());
        DLL list2=freqMap.get(freq);
        list2.addLast(node);
    }
    public int get(int key) 
    {
        Node node=keyMap.get(key);
        if(node==null) return -1;
        else
        {
            update(node);
            return node.val;
        }
    }
    
    public void put(int key, int value) 
    {
        if(cap==0) return;
        if(keyMap.containsKey(key))
        {
            Node node=keyMap.get(key);
            node.val=value;
            update(node);
        }
        else
        {
            if(keyMap.size()==cap)
            {
                DLL list=freqMap.get(minFreq);
                Node toBeDeleted=list.removeFirst();
                if(list.size==0) freqMap.remove(minFreq);
                keyMap.remove(toBeDeleted.key);
            }
            minFreq=1;
            Node node=new Node(key, value);
            freqMap.putIfAbsent(minFreq, new DLL());
            freqMap.get(minFreq).addLast(node);
            keyMap.put(key, node);
        }
    }
}

