class Solution {
    public int maximumRequests(int n, int[][] requests) 
    {
        int[] employees=new int[n];
        return backtrack(0, employees, requests, 0);
    }
    private int backtrack(int idx, int[] employees, int[][] requests, int count)
    {
        if(idx==requests.length)
        {
            for(int no: employees)
            {
                if(no!=0) return 0;
            }
            return count;
        }

        int[] req=requests[idx];
        //take
        employees[req[0]]--;
        employees[req[1]]++;
        int take=backtrack(idx+1, employees, requests, count+1);
        employees[req[0]]++;
        employees[req[1]]--;

        int notTake=backtrack(idx+1, employees, requests, count);

        return Math.max(take, notTake);
    }
}