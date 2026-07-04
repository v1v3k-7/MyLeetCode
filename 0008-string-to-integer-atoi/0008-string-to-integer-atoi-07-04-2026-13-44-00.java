class Solution {
    public int myAtoi(String s) 
    {
        char[] arr=s.toCharArray();
        StringBuilder sb=new StringBuilder("");
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]==' ' && sb.length()==0) continue;

            if((arr[i]<=57 && arr[i]>=48)) sb.append(arr[i]);
            else if((sb.length()==0) && (arr[i]=='-' || arr[i]=='+')) sb.append(arr[i]);
            else break;
        }

        int n=sb.length();
        if(n==0 || sb.toString().equals("-") || sb.toString().equals("+")) return 0;


        int sign=1;
        int start=0;
        if(sb.charAt(0)=='-')
        {
            sign=-1;
            start=1;
        }
        else if(sb.charAt(0)=='+')
        {
            start=1;
        }
        long num=0;
        for(int i=start; i<n; i++)
        {
            int digit=sb.charAt(i)-'0';
            num=num*10 + digit;
            if(sign==1 && num>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else if(sign==-1 && -num<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return (int)(sign*num);
    }
}