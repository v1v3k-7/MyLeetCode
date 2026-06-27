class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) 
    {
        HashMap<String, List<String>> adjMap=new HashMap<>(); // mail as node, mail --> linked mails
        HashMap<String, String> names=new HashMap<>(); //mail -> name
        for(List<String> account: accounts)
        {
            int n=account.size();
            if(!adjMap.containsKey(account.get(1))) adjMap.put(account.get(1), new ArrayList<>());
            // names.put(account.get(1), account.get(0));
            if(n<2) continue;
            adjMap.get(account.get(1)).addAll(account.subList(2, n));
            for(int i=2; i<n; i++)
            {
                if(!adjMap.containsKey(account.get(i))) adjMap.put(account.get(i), new ArrayList<>());
                adjMap.get(account.get(i)).add(account.get(1));
                names.put(account.get(i), account.get(0));
            }
        }
        List<List<String>> res=new ArrayList<>();
        Set<String> visited=new HashSet<>();
        for(List<String> account: accounts)
        {
            String mail=account.get(1);
            if(visited.contains(mail)) continue;
            List<String> acc=new ArrayList<>();
            dfs(mail, adjMap, visited, acc);
            Collections.sort(acc);
            acc.add(0, account.get(0));
            res.add(acc);
        }

        return res;
    }

    public void dfs(String src, HashMap<String, List<String>> adjMap, Set<String> visited, List<String> res)
    {
        res.add(src);
        visited.add(src);
        for(String neighbour: adjMap.get(src))
        {
            if(!visited.contains(neighbour)) 
            {
                dfs(neighbour, adjMap, visited, res);
            }
        }
    }
}