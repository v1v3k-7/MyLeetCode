class Solution 
{
    public String longestCommonPrefix(String[] strs) 
    {
        TrieNode root=new TrieNode();
        for(String s: strs)
        {
            TrieNode temp=root;
            for(char ch: s.toCharArray())
            {
                if(!temp.contains(ch))
                {
                    temp.add(ch);
                }
                temp=temp.get(ch);
                temp.incrementCount();
            }
        }

        TrieNode temp=root;
        int n=strs.length;
        int count=0;
        for(char ch: strs[0].toCharArray())
        { 
            temp=temp.get(ch);
            if(temp.getCount()!=n) break;
            count++;
        }

        return strs[0].substring(0, count);
    }
}
class TrieNode
{
    TrieNode trieNode[]=new TrieNode[26];
    int count=0;
    public void add(char ch)
    {
        trieNode[ch-'a']=new TrieNode();
    }
    public boolean contains(char ch)
    {
        return trieNode[ch-'a']!=null;
    }
    public TrieNode get(char ch)
    {
        return trieNode[ch-'a'];
    }
    public void incrementCount()
    {
        count++;
    }
    public int getCount()
    {
        return count;
    }
}