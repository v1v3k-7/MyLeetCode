class Solution {
    public int minimumPushes(String word) 
    {
        int n=word.length();
        int arr[]=new int[26];
        int curr=0;
        int press=1;
        int res=0;
        for(int i=0; i<n; i++)
        {
            char ch=word.charAt(i);
            if(arr[ch-'a']>0)
            {
                res+=arr[ch-'a'];
                continue;
            }

            if(curr<8)
            {
                arr[ch-'a']=press;
                res+=press;
                curr++;
            }
            else
            {
                press++;
                arr[ch-'a']=press;
                res+=press;
                curr=1;
            }
        }
        return res;
    }
}