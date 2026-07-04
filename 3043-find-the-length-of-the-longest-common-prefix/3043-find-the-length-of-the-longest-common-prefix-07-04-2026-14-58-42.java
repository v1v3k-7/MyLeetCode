class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) 
    {
        TrieNode root=new TrieNode();
        for(int no: arr2)
        {
            TrieNode temp=root;
            String s=String.valueOf(no);
            int n=s.length();
            for(int i=0; i<n; i++)
            {
                int digit=s.charAt(i)-'0';
                if(!temp.contains(digit)) temp.add(digit);
                temp=temp.get(digit);
            }
        }
        int maxLen=0;
        for(int no: arr1)
        {
            TrieNode temp=root;
            String s=String.valueOf(no);
            int len=0;
            int n=s.length();
            for(int i=0; i<n; i++)
            {
                int digit=s.charAt(i)-'0';
                if(temp.contains(digit)) len++;
                else break;
                temp=temp.get(digit);
            }
            if(maxLen<len) maxLen=len;
        }
        return maxLen;
    }
}
class TrieNode
{
    TrieNode trieNode[]=new TrieNode[10];
    TrieNode get(int i)
    {
        return trieNode[i];
    }
    boolean contains(int i)
    {
        return trieNode[i]!=null;
    }
    void add(int i)
    {
        trieNode[i]=new TrieNode();
    }
}