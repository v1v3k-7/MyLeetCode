/* The functions which
builds the segment tree */
class GfG 
{
    static int st[];

    public static int[] constructST(int arr[], int n) 
    {
        st=new int[4*n];
        buildSG(arr, 0, 0, n-1);
        return st;
    }

    
    public static int RMQ(int st[], int n, int l, int r) 
    {
        return rangeQueryMin(st, 0, l, r, 0, n-1);
    }
    
    private static int rangeQueryMin(int[] st, int idx, int start, int end, int l, int r)
    {
        if(l>=start && r<=end) return st[idx];
        else if(l>end || r<start) return Integer.MAX_VALUE;
        // else part
        int mid=l+(r-l)/2;
        return Math.min(rangeQueryMin(st, 2*idx+1, start, end, l, mid), rangeQueryMin(st, 2*idx+2, start, end, mid+1, r));
    }
    
    private static void buildSG(int[] arr, int idx, int l, int r)
    {
        if(l==r)
        {
            st[idx]=arr[l];
            return;
        }
        int mid=l+(r-l)/2;
        buildSG(arr, 2*idx+1, l, mid);
        buildSG(arr, 2*idx+2, mid+1, r);
        
        st[idx]=Math.min(st[2*idx+1], st[2*idx+2]);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna