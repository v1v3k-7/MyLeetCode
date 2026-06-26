class Solution {
    public ArrayList<String> generateNeighbours(String word, HashSet<String> set)
    {
        ArrayList<String> res=new ArrayList<>();
        int n=word.length();
        for(int i=0; i<n; i++)
        {
            for(char ch='a'; ch<='z'; ch++)
            {
                if(ch==word.charAt(i)) continue;
                String newWord=word.substring(0, i)+ch+word.substring(i+1, n);
                if(set.contains(newWord)) res.add(newWord);
            }
        }
        return res;
    }
    
    public ArrayList<ArrayList<String>> findSequences(String[] words, String s,
                                                      String e) 
    {
        ArrayList<ArrayList<String>> res=new ArrayList<>();
        HashSet<String> set=new HashSet<>();
        for(String str:words) set.add(str);
        if(!set.contains(e)) return res;
        
        Queue<ArrayList<String>> queue=new LinkedList<>();
        
        ArrayList<String> dummy=new ArrayList();
        dummy.add(s);
        queue.offer(dummy);
        if(set.contains(s)) set.remove(s);
        
        int level=0;
        int resLevel=-1;
        while(!queue.isEmpty())
        {
            HashSet<String> usedWords=new HashSet<>();
            
            int curSize=queue.size();
            for(int i=0; i<curSize; i++)
            {
                ArrayList<String> nodeList=queue.poll();
                String node=nodeList.get(nodeList.size()-1);
                if(node.equals(e))
                {
                    res.add(nodeList);
                    resLevel=level;
                }
                ArrayList<String> neighbours=generateNeighbours(node, set);
                for(String str: neighbours)
                {
                    nodeList.add(str);
                    queue.offer(new ArrayList<>(nodeList));
                    nodeList.remove(nodeList.size()-1);
                    usedWords.add(str);
                }
            }
            for(String str: usedWords) set.remove(str);
            if(resLevel==level) break;
            level++;
        }
        return res;
    }
}




// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna