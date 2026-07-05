class Solution {
    public boolean canMakeSubsequence(String s, String t) 
    {
        int m=s.length();
        int n=t.length();
        if(m>n) return false;

        int[] left=new int[m];
        int[] right=new int[m];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);

        int j=0;
        for(int i=0; i<m; i++)
        {
            while(j<n && s.charAt(i)!=t.charAt(j)) j++;
            if(j==n) break; //nhi mila element, iska or iske bad ka pura left arr -1 hoga
            left[i]=j;
            j++;
        }

        if(left[m-1]!=-1) return true; //pura element hi mil gya, no missing

        j=n-1;
        for(int i=m-1; i>=0; i--)
        {
            while(j>=0 && s.charAt(i)!=t.charAt(j)) j--;
            if(j<0) break; //nhi mila element
            right[i]=j;
            j--; 
        }

        for(int i=0; i<m; i++)
        {
            if((i==0||left[i-1]!=-1) && (i==m-1||right[i+1]!=-1))
            {
                int L=(i==0)?-1:left[i-1];
                int R=(i==m-1)?n:right[i+1];
                if(R-L>=2) return true;
            }
        }
        return false;
    }
}