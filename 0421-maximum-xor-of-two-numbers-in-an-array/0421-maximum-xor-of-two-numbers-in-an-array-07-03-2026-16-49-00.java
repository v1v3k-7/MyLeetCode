class Solution 
{
    public int findMaximumXOR(int[] nums) 
    {
        TrieNode root=new TrieNode();
        for(int num: nums)
        {
            TrieNode temp=root;
            for(int i=31; i>=0; i--)
            {
                int bit=(1 & (num>>i));
                if(!temp.contains(bit)) temp.add(bit);
                temp=temp.get(bit);
            }
        }

        int maxXOR=0;
        for(int num: nums)
        {
            int xor=0;
            TrieNode temp=root;
            for(int i=31; i>=0; i--)
            {
                int bit=(1 & (num>>i));
                //(1-bit) --> toggle bit like if 1->0 or 0->1
                if(temp.contains(1-bit))
                {
                    xor=xor | (1<<i);
                    temp=temp.get(1-bit);
                }
                else temp=temp.get(bit);
            }
            if(maxXOR<xor) maxXOR=xor;
        }
        return maxXOR;
    }
}
class TrieNode
{
    TrieNode trieNode[]=new TrieNode[2];
    void add(int i)
    {
        trieNode[i]=new TrieNode();
    }
    TrieNode get(int i)
    {
        return trieNode[i];
    }
    boolean contains(int i)
    {
        return trieNode[i]!=null;
    }
}