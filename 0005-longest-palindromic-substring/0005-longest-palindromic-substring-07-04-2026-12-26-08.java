class Solution {
    public String longestPalindrome(String s) 
    {
        char[] arr=s.toCharArray();
        int n=arr.length;
        int len=0;
        int[] ans=new int[2];
        for(int i=0; i<n; i++)
        {
            int ex[]=expand(arr, i);
            int l=ex[1]-ex[0]+1;
            if(len<l)
            {
                ans=ex;
                len=l;
            }
        }
        return s.substring(ans[0], ans[1]+1);
    }
    public int[] expand(char[] arr, int i)
    {
        int n=arr.length;
        int hi=i+1;
        int li=i-1;
        while(hi<n && arr[i]==arr[hi])
        {
            hi++;
        }
        while(hi<n && li>=0 && arr[li]==arr[hi])
        {
            hi++;
            li--;
        }
        return new int[]{li+1, hi-1};
    }
}