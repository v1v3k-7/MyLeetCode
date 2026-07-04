class Solution {
    public int romanToInt(String s) 
    {
        char[] arr=s.toCharArray();
        int res=0;
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            int x=findValue(arr[i]);
            if(i+1<n && x<findValue(arr[i+1])) res-=x;
            else res+=x;
        }
        return res;
    }
    int findValue(char ch)
    {
        int x=0;
        switch(ch)
        {
            case 'I': 
                x=1;
                break;
            case 'V':
                x=5;
                break;
            case 'X':
                x=10;
                break;
            case 'L':
                x=50;
                break;
            case 'C':
                x=100;
                break;
            case 'D':
                x=500;
                break;
            case 'M':
                x=1000;
                break;
        }
        return x;
    }
}