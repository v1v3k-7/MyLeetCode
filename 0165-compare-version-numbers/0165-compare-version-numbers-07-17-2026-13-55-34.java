class Solution {
    public int compareVersion(String version1, String version2) 
    {
        String[] v1=version1.split("\\.");
        String[] v2=version2.split("\\.");
        int len1=v1.length, len2=v2.length;
        int max=Math.max(len1, len2);
        for(int i=0; i<max; i++)
        {
            int val1=(i>=len1)?0:Integer.parseInt(v1[i]);
            int val2=(i>=len2)?0:Integer.parseInt(v2[i]);

            if(val2<val1) return 1;
            else if(val2>val1) return -1;
        }
        return 0;
    }
}