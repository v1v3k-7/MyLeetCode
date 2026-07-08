class Solution {
    public long sumAndMultiply(int n) 
    {
        long sum=0;
        long concat=0;
        long place=1;
        for(int i=n; i!=0; i/=10)
        {
            int digit=i%10;
            if(digit==0) continue;
            sum+=digit;
            concat+=(digit*place);
            place*=10;
        }
        return sum*concat;
    }
}