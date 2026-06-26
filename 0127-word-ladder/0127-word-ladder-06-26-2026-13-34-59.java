class Solution 
{
    public ArrayList<String> getNeighbour(String word, HashSet<String> set)
    {
        ArrayList<String> res=new ArrayList<>();
        int s=word.length();
        for(int i=0; i<s; i++)
        {
            for(char ch='a'; ch<='z'; ch++)
            {
                if(ch==word.charAt(i)) continue;
                String newWord=word.substring(0, i) + ch + word.substring(i+1, s);
                if(set.contains(newWord)) res.add(newWord);
            }
        }
        return res;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) 
    {
        HashSet<String> set=new HashSet<>();
        for(String s: wordList) set.add(s);
        if(!set.contains(endWord)) return 0;

        Queue<String> queue=new LinkedList<>();
        queue.offer(beginWord);
        if(set.contains(beginWord)) set.remove(beginWord); //remove if preset and we are making visited by removing it from set
        int level=0;
        while(!queue.isEmpty())
        {
            int curLevelSize=queue.size();
            for(int i=0; i<curLevelSize; i++)
            {
                String node=queue.poll();
                if(node.equals(endWord)) return level+1;

                ArrayList<String> neighbours=getNeighbour(node, set);
                for(String str:neighbours)
                {
                    queue.offer(str);
                    set.remove(str); //marked visited;
                }
            }
            level++;
        }
        return 0;
    }
}