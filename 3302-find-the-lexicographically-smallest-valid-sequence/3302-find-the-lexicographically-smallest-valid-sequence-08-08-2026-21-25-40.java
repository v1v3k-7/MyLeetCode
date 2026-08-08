class Solution {
    public int[] validSequence(String word1, String word2) 
    {
        int n=word1.length();
        int m=word2.length();
        int[] rightHandMatch=new int[n];
        int j=m-1;
        int match=0;
        for(int i=n-1; i>=0; i--)
        {
            if(j>=0 && word1.charAt(i)==word2.charAt(j)) 
            {
                match++;
                j--;
            }
            rightHandMatch[i]=match;
        }
        int i=0;
        j=0;
        boolean hasChangePower=true;
        int[] res=new int[m];
        while(j<m && i<n)
        {
            if(word1.charAt(i)==word2.charAt(j))
            {
                res[j]=i;
                i++;
                j++;
            }
            else if(hasChangePower && i+1<n && rightHandMatch[i+1]>=m-j-1)
            {
                res[j]=i;
                i++;
                j++;
                hasChangePower=false;
            }
            else
            {
                i++;
            }
        }
        if(j<m) return new int[0];
        else return res;
    }
}