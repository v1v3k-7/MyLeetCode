class Solution {
    public String countAndSay(int n) 
    {
        if(n==1) return "1";
        String prev=countAndSay(n-1);
        StringBuilder sb=new StringBuilder("");
        int len=prev.length(), count=0;
        for(int i=0; i<len; i++)
        {
            count++;
            if(i==len-1 || prev.charAt(i)!=prev.charAt(i+1))
            {
                sb.append(count).append(prev.charAt(i));
                count=0;
            }
        }
        return sb.toString();
    }
}