class Solution {
    public String longestPalindrome(String s) 
    {
        char[] arr=s.toCharArray();
        int n=arr.length;
        String res="";
        for(int i=0; i<n; i++)
        {
            String str=expand(arr, i);
            if(res.length()<str.length()) res=str;
        }
        // System.out.println(expand(arr, 1));
        return res;
    }
    public String expand(char[] arr, int i)
    {
        int n=arr.length;
        int hi=i+1;
        int li=i-1;
        // int len=1;
        StringBuilder sb=new StringBuilder("");
        sb.append(arr[i]);
        while(hi<n && arr[i]==arr[hi])
        {
            // len++;
            sb.append(arr[hi]);
            hi++;
        }
        while(li>=0 && arr[i]==arr[li])
        {
            // len++;
            sb.insert(0, arr[li]);
            li--;
        }
        while(hi<n && li>=0 && arr[li]==arr[hi])
        {
            // len+=2;
            sb.append(arr[hi]);
            hi++;
            sb.insert(0, arr[li]);
            li--;
        }
        return sb.toString();
    }
}