class Solution {
    public boolean isHappy(int n) 
    {
        HashSet<Integer> set=new HashSet<>();
        while(n!=1)
        {
            if(set.contains(n)) return false;
            set.add(n);
            int no=0;
            for(int i=n; i!=0; i/=10)
            {
                int digit=i%10;
                no+=digit*digit;
            }
            n=no;
        }
        return true;
    }
}