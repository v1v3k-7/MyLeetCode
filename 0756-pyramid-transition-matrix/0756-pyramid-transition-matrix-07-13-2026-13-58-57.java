class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) 
    {
        HashMap<String, List<Character>> map=new HashMap<>();
        for(String s: allowed)
        {
            String key=s.substring(0, 2);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s.charAt(2));
        }
        return solve(bottom, map, 0, new StringBuilder());
    }
    private boolean solve(String bottom, HashMap<String, List<Character>> map, int idx, StringBuilder next)
    {
        int n=bottom.length();
        if(n==1) return true;

        if(idx==n-1)
        {
            return solve(next.toString(), map, 0, new StringBuilder());
        }

        String str=bottom.substring(idx, idx+2);
        if(!map.containsKey(str)) return false;

        for(Character ch: map.get(str))
        {
            next.append(ch);
            if(solve(bottom, map, idx+1, next)) return true;
            next.deleteCharAt(next.length()-1);
        }

        return false;
    }
}