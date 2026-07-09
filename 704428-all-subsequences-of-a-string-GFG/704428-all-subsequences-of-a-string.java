class Solution {
    public List<String> powerSet(String s) 
    {
        List<String> res=new ArrayList<>();
        backtrack(0, s, new StringBuilder(), res);
        Collections.sort(res);
        return res;
    }
    public void backtrack(int idx, String s, StringBuilder sb, List<String> res)
    {
        if(idx==s.length())
        {
            res.add(sb.toString());
            return;
        }
        
        
        sb.append(s.charAt(idx));
        backtrack(idx+1, s, sb, res); //trust;
        sb.deleteCharAt(sb.length()-1);
        
        backtrack(idx+1, s, sb, res);
        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna