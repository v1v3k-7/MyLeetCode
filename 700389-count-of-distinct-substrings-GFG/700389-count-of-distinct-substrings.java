class Solution {
    public static int countSubs(String s) 
    {
        TrieNode root=new TrieNode();
        char[] chars=s.toCharArray();
        int n=s.length();
        int count=0;
        for(int i=0; i<n; i++)
        {
            TrieNode temp=root;
            for(int j=i; j<n; j++)
            {
                if(!temp.contains(chars[j]))
                {
                    count++;
                    temp.add(chars[j]);
                }
                temp=temp.get(chars[j]);
            }
        }
        return count;
    }
    static class TrieNode
    {
        TrieNode trieNode[]=new TrieNode[26];
        
        TrieNode get(char ch)
        {
            return trieNode[ch-'a'];
        }
        boolean contains(char ch)
        {
            return trieNode[ch-'a']!=null;
        }
        void add(char ch)
        {
            trieNode[ch-'a']=new TrieNode();
        }
    }
    
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna