class Solution {
    public String longestPalindrome(String s) 
    {
        int n=s.length();
        int maxLen=0;
        int x=-1, y=-1;
        for(int i=0; i<n; i++)
        {
            for(int j=i; j<n; j++)
            {
                if(isPalindrome(s, i, j))
                {
                    int len=j-i+1;
                    if(len>maxLen)
                    {
                        maxLen=len;
                        x=i;
                        y=j;
                    }
                }
            }
        }
        return s.substring(x, y+1);
    }
    public boolean isPalindrome(String s, int i, int j)
    {
        if(i>=j) return true;
        if(s.charAt(i)==s.charAt(j)) return isPalindrome(s, i+1, j-1);
        else return false;
    }
}