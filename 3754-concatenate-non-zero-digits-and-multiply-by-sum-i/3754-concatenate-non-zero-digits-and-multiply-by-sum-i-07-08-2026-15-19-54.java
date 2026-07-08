class Solution {
    public long sumAndMultiply(int n) 
    {
        long sum=0;
        long concat=0;
        long place=0;
        for(int i=n; i!=0; i/=10)
        {
            int digit=i%10;
            sum+=digit;
            if(digit!=0) 
            {
                if(place==0)
                {
                    concat=digit;
                    place=10;
                }
                else
                {
                    concat=place*digit + concat;
                    place*=10;
                }
            }
        }
        return sum*concat;
    }
}