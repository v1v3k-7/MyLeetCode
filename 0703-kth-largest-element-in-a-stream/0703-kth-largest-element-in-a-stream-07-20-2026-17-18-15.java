class KthLargest 
{
    PriorityQueue<Integer> minPQ=new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) 
    {
        this.k=k;
        for(int no: nums)
        {
            if(minPQ.size()>=k)
            {
                if(minPQ.peek()<=no)
                {
                    minPQ.poll();
                    minPQ.offer(no);
                }
            }
            else minPQ.offer(no);
        }
    }
    
    public int add(int val) 
    {
        if(minPQ.size()<k) minPQ.offer(val);
        else
        {
            if(minPQ.peek()<=val)
            {
                minPQ.poll();
                minPQ.offer(val);
            }
        }
        return minPQ.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */