class Solution {
    public int minimumPushes(String word) 
    {
        int n=word.length();
        int[] freq=new int[26];
        for(int i=0; i<n; i++)
        {
            freq[word.charAt(i)-'a']++;
        }
        Arrays.sort(freq);
        int res=0;
        int press=1;
        int cnt=0;
        for(int i=25; i>=0; i--)
        {
            if(freq[i]==0) break;
            res+=press*freq[i];
            cnt++;
            if(cnt==8)
            {
                cnt=0;
                press++;
            }
        }
        return res;
    }
}