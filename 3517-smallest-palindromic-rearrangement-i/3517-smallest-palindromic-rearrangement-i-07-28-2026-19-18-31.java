class Solution {
    public String smallestPalindrome(String s) 
    {
        int n=s.length();
        if(n<=3) return s;

        char arr[]=s.substring(0, n/2).toCharArray();
        Arrays.sort(arr);
        String left=new String(arr);
        StringBuilder sb=new StringBuilder(left);
        String right=sb.reverse().toString();
        if((n&1)==1) //even len
        {
            return left + s.charAt(n/2) + right;
        }
        return left+right;
    }
}