class Solution {
    public List<Integer> findMissingElements(int[] nums) 
    {
        List<Integer> res=new ArrayList<>();
        // HashSet<Integer> set=new HashSet<>();
        int[] arr=new int[101];
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        for(int no: nums)
        {
            if(no<min) min=no;
            if(no>max) max=no;
            arr[no]=no;
        }
        for(int i=min; i<=max; i++)
        {
            if(arr[i]==0) res.add(i);
        }
        return res;
    }
}