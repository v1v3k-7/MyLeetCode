class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) 
    {
        //store all in map(choose map bcz we have to retriever operation from query)
        int n=values.length;
        HashMap<String, HashMap<String, Double>> map=new HashMap<>();
        for(int i=0; i<n; i++)
        {
            String dividend=equations.get(i).get(0);
            String divisor=equations.get(i).get(1);
            double value=values[i];
            if(!map.containsKey(dividend))
            {
                map.put(dividend, new HashMap<>());
            }
            if(!map.containsKey(divisor))
            {
                map.put(divisor, new HashMap<>());
            }

            map.get(dividend).put(divisor, value);
            map.get(divisor).put(dividend, 1.0/value);
        }
        int q=queries.size();
        double[] res=new double[q];
        for(int i=0; i<q; i++)
        {
            String dividend=queries.get(i).get(0);
            String divisor=queries.get(i).get(1);
            if(!map.containsKey(dividend) || !map.containsKey(divisor)) res[i]=-1.0;
            else if(dividend.equals(divisor)) res[i]=1.0;
            else
            {
                Set<String> visited=new HashSet<>();
                res[i]=dfsBacktrack(dividend, divisor, 1, visited, map);
            }
        }
        return res;
    }

    public double dfsBacktrack(String src, String target, double prod, Set<String> visited, HashMap<String, HashMap<String, Double>> map)
    {
        double res=-1;
        visited.add(src);
        HashMap<String, Double> neighbours=map.get(src);
        if(neighbours.containsKey(target)) res=prod*neighbours.get(target);
        else
        {
            for(Map.Entry<String, Double> e: neighbours.entrySet())
            {
                if(visited.contains(e.getKey())) continue;
                res=dfsBacktrack(e.getKey(), target, prod*e.getValue(), visited, map);
                if(res!=-1) return res;
            }
        }
        visited.remove(src);
        return res;
    }
}