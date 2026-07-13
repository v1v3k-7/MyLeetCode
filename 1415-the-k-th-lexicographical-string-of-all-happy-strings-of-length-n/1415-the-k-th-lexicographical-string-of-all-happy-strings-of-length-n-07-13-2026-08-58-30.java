class Solution {
    int k;
    int count=0;
    public String getHappyString(int n, int k) 
    {
        this.k=k;
        return backtrack(n, new StringBuilder());
    }
    private String backtrack(int n, StringBuilder sb)
    {
        int s=sb.length();
        if(s==n)
        {
            count++;
            if(count==k) return sb.toString();
            return "";
        }

        for(char ch='a'; ch<='c'; ch++)
        {
            if(s>0 && sb.charAt(s-1)==ch) continue;
            sb.append(ch);
            String str=backtrack(n, sb);
            if(!str.isEmpty()) return str;
            sb.deleteCharAt(s);
        }
        return "";
    }
}