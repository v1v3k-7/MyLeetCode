class Solution {
    public int findKthLargest(int[] nums, int k) 
    {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int no: nums)
        {
            if(pq.size()>=k)
            {
                if(pq.peek()<=no)
                {
                    pq.poll();
                    pq.offer(no);
                }
            }
            else pq.offer(no);
        }
        return pq.peek();
    }
}