class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) 
    {
        List<List<Integer>> res=new ArrayList<>();
        int i=0, j=0;
        int n=series1.length, m=series2.length;
        while(i<n && j<m)
        {
            if(series1[i][0]==series2[j][0])
            {
                res.add(List.of(series1[i][0], series1[i][1]+series2[j][1]));
                i++;
                j++;
            }
            else
            {
                if(series1[i][0]<series2[j][0])
                {
                    res.add(List.of(series1[i][0], series1[i][1]+series2[j][1]));
                    i++;
                }
                else
                {
                    res.add(List.of(series2[j][0], series1[i][1]+series2[j][1]));
                    j++;
                }
            }
        }
        while(i<n)
        {
            res.add(List.of(series1[i][0], series1[i][1]));
            i++;
        }
        while(j<m)
        {
            res.add(List.of(series2[j][0], series2[j][1]));
            j++;
        }
        return res;
    }
}