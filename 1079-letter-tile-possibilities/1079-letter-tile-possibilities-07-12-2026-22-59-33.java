class Solution {
    int n;
    public int numTilePossibilities(String tiles) 
    {
        n=tiles.length();
        boolean[] seen=new boolean[n];
        return backtrack(tiles, seen);
    }
    private int backtrack(String tiles, boolean[] seen)
    {
        HashSet<Character> set=new HashSet<>();
        int res=0;
        for(int i=0; i<n; i++)
        {
            if(seen[i]) continue;
            if(set.contains(tiles.charAt(i))) continue;
            set.add(tiles.charAt(i));
            seen[i]=true;
            res+=1+backtrack(tiles, seen);
            seen[i]=false;
        }
        return res;
    }
}