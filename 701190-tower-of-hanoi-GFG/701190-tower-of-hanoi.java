class Solution {
    public int towerOfHanoi(int n, int from, int to, int aux) 
    {
        if(n==0) return 0;
        if(n==1)
        {
            // System.out.println("move disk " + n + " from rod " + from + " to rod " + to);
            return 1;
        }
        int count=0;
        count=towerOfHanoi(n-1, from, aux, to); //sent (n-1) rod from 'From' rod to rod "To'"
        
        // System.out.println("move disk " + n + " from rod " + from + " to rod " + to);
        count++;
        
        count+=towerOfHanoi(n-1, aux, to, from);
        
        return count;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna