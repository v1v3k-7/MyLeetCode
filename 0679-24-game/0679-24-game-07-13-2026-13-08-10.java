class Solution {
    double epsilon=0.01;
    public boolean judgePoint24(int[] cards) 
    {
        List<Double> list=new ArrayList<>(4);
        for(int card: cards) list.add(1.0 * card);

        return solve(list);
    }

    private boolean solve(List<Double> cards)
    {
        int n=cards.size();
        if(n==1)
        {
            return Math.abs(cards.get(0)-24)<=epsilon;
        }

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(i==j) continue; 
                //picked two numbers cards[i] & cards[j];
                double a=cards.get(i);
                double b=cards.get(j);

                List<Double> temp=new ArrayList<>(n-1);
                for(int k=0; k<n; k++)
                {
                    if(k!=i && k!=j) temp.add(cards.get(k));
                }

                List<Double> possibleVal=new ArrayList<>(6);
                possibleVal.add(a+b);
                possibleVal.add(a-b);
                possibleVal.add(b-a);
                possibleVal.add(a*b);
                if(b>0.00) possibleVal.add(a/b);
                if(a>0.00) possibleVal.add(b/a);

                for(Double d: possibleVal)
                {
                    temp.add(d);
                    if(solve(temp)) return true;
                    temp.remove(temp.size()-1);
                }
            }
        }

        return false;
    }
}