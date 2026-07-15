class Solution 
{
    public int countSubstrings(String s) 
    {
        int n=s.length();
        int count=0;
        for(int i=0; i<n; i++)
        {
            for(int j=i; j<n; j++)
            {
                if(isPalin(i, j, s)==1) count++;
            }
        }
        return count;
    }
    private int isPalin(int i, int j, String s) //0->False, 1-> True
    {
        if(i>j) return 1;
        if(s.charAt(i)==s.charAt(j)) 
        {
            return isPalin(i+1, j-1, s);
        }
        return 0;
    }
}