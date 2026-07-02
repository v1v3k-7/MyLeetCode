class Solution {
    public int prefixCount(String[] words, String pref) 
    {
        Trie trie=new Trie();
        for(String s: words) trie.insert(s);
        return trie.prefixCount(pref);
    }
}
class TrieNode
{
    TrieNode trieNode[];
    int count;
    TrieNode()
    {
        trieNode=new TrieNode[26];
        count=0;
    }
    boolean containsChar(char ch)
    {
        return trieNode[ch-'a']!=null;
    }
    TrieNode get(char ch)
    {
        return trieNode[ch-'a'];
    }
    void add(char ch)
    {
        trieNode[ch-'a']=new TrieNode();
    }
}
class Trie
{
    TrieNode root=new TrieNode();
    public void insert(String word)
    {
        TrieNode temp=root;
        for(char ch: word.toCharArray())
        {
            if(!temp.containsChar(ch))
            {
                temp.add(ch);
            }
            temp=temp.get(ch);
            temp.count++;
        }
    }
    public int prefixCount(String prefix)
    {
        TrieNode temp=root;
        for(char ch: prefix.toCharArray())
        {
            if(!temp.containsChar(ch))
            {
                return 0;
            }
            temp=temp.get(ch);
        }
        return temp.count;
    }
}