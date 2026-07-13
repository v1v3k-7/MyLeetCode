class Solution 
{
    HashMap<String, Boolean> dp=new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) 
    {
        String[][] map=new String[6][6];
        for(String s: allowed)
        {
            int i=s.charAt(0)-'A';
            int j=s.charAt(1)-'A';
            if(map[i][j]==null) map[i][j]="";
            map[i][j]+=s.charAt(2);
        }

        return solve(bottom, map, 0, new StringBuilder());
    }
    private boolean solve(String bottom, String[][] map, int idx, StringBuilder next)
    {
        int n=bottom.length();
        if(n==1) return true;

        if(idx==n-1)
        {
            String newBottom=next.toString();
            if(dp.containsKey(newBottom)) return dp.get(newBottom);

            boolean ans=solve(newBottom, map, 0, new StringBuilder());
            dp.put(newBottom, ans);
            return ans;
        }

        int i=bottom.charAt(idx)-'A';
        int j=bottom.charAt(idx+1)-'A';
        if(map[i][j]==null) 
        {
            return false;
        }

        for(Character ch: map[i][j].toCharArray())
        {
            next.append(ch);
            if(solve(bottom, map, idx+1, next)) return true;
            next.deleteCharAt(next.length()-1);
        }
        return false;
    }
}