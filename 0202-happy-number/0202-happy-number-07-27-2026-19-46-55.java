class Solution {
    public boolean isHappy(int n) 
    {
        HashSet<Integer> set=new HashSet<>();
        while(n!=1 && !set.contains(n))
        {
            set.add(n);
            n=nextNo(n);
        }
        return n==1;
    }
    private int nextNo(int no)
    {
        int sum=0;
        while(no!=0)
        {
            int digit=no%10;
            sum+=digit*digit;
            no/=10;
        }
        return sum;
    }
}