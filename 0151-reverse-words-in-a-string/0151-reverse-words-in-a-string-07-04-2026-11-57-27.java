class Solution {
    public String reverseWords(String s) 
    {
        StringBuilder sb=new StringBuilder("");
        char[] arr=s.toCharArray();
        int i=arr.length-1;
        int end=i;
        while(i>=0)
        {
            while(i>=0 && arr[i]==' ') i--;
            end=i;
            while(i>=0 && arr[i]!=' ') i--;
            for(int j=i+1; j<=end; j++) sb.append(arr[j]);
            while(i>=0 && arr[i]==' ') i--;
            if(i+1>0) sb.append(" ");
        }
        return sb.toString();
    }
}