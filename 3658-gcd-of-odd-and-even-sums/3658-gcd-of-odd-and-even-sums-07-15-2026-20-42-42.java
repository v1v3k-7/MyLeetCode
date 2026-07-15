class Solution {
    public int gcdOfOddEvenSums(int n) 
    {
        int odd=(int)(n/2.0 * (1+(2*n-1)));
        int even=(int) (n/2.0 * (2+(2*n)));
        return findGCD(even, odd);
    }
    private int findGCD(int a, int b)
    {
        return (b==0)? a: findGCD(b, a%b);
    }
}