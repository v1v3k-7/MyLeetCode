class Solution 
{
    String res="";
    public String longestSubsequenceRepeatedK(String s, int k) 
    {
        int[] freq=new int[26];
        for(char ch: s.toCharArray()) freq[ch-'a']++;

        int[] useable=new int[26];
        boolean[] canUse=new boolean[26];
        for(int i=0; i<26; i++)
        {
            if(freq[i]>=k) 
            {
                canUse[i]=true;
                useable[i]=freq[i]/k;
            }
        }

        int maxLen=s.length()/k;

        backtrack(s, new StringBuilder(), useable, canUse, k, maxLen);
        return res;
    }

    private void backtrack(String s, StringBuilder sb, int[] useable, boolean[] canUse, int k, int maxLen)
    {
        int l=sb.length();
        if(l>maxLen) return;

        if(l>res.length() && isSubsequence(s, sb, k))
        {
            res=sb.toString();
        }

        for(int i=25; i>=0; i--)
        {
            if(!canUse[i] || useable[i]==0) continue;

            useable[i]--;
            sb.append((char)(i+'a'));
            backtrack(s, sb, useable, canUse, k, maxLen);
            sb.deleteCharAt(l);
            useable[i]++;
        }
    }
    private boolean isSubsequence(String s, StringBuilder sub, int k)
    {
        int i=0, j=0;
        int n=s.length(), m=sub.length();
        while(i<n && j<m*k)
        {
            if(sub.charAt(j%m)==s.charAt(i)) j++;
            i++;
        }
        return j==m*k;
    }
}