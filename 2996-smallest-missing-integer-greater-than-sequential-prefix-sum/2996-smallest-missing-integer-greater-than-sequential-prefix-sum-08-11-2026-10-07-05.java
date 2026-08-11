class Solution {
    public int missingInteger(int[] nums) 
    {
        int cur=0;
        int sum=0;
        boolean seq=true;
        HashSet<Integer> set=new HashSet<>();
        for(int no: nums)
        {
            if(cur==0 || (seq && no==cur+1))
            {
                cur=no;
                sum+=no;
            }
            else seq=false;
            if(no>=sum) set.add(no);
        }
        if(sum>50) return sum;
        for(; sum<=50; sum++)
        {
            if(!set.contains(sum)) return sum;
        }
        return sum;
    }
}