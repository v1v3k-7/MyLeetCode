class Solution 
{
    List<List<Integer>> res=new ArrayList<>();
    int n;
    public List<List<Integer>> permuteUnique(int[] nums) 
    {
        n=nums.length;
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int no: nums)
        {
            map.put(no, map.getOrDefault(no, 0)+1);
        }
        backtrack(nums, new ArrayList<>(), map);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> current, HashMap<Integer, Integer> map)
    {
        if(current.size()==n)
        {
            res.add(new ArrayList<>(current));
            return;
        }
        for(Map.Entry<Integer, Integer> e: map.entrySet())
        {
            int num=e.getKey();
            int count=e.getValue();

            if(count==0) continue;

            current.add(num);
            map.put(num, count-1);
            backtrack(nums, current, map);
            current.remove(current.size()-1);
            map.put(num, count);
        }
    }
}