class Solution {
    public void mergeSort(int arr[], int l, int r) 
    {
        if(l==r) return;
        int mid=l+(r-l)/2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        
        merge(arr, l, mid, r);
    }
    
    public void merge(int[] arr, int l, int mid, int r)
    {
        int n=r-l+1;
        int[] temp=new int[n];
        int i=l, j=mid+1, k=0;
        while(i<=mid && j<=r)
        {
            if(arr[i]<arr[j])
            {
                temp[k]=arr[i];
                k++;
                i++;
            }
            else
            {
                temp[k]=arr[j];
                k++;
                j++;
            }
        }
        while(i<=mid) 
        {
            temp[k++]=arr[i];
            i++;
        }
        while(j<=r)
        {
            temp[k++]=arr[j];
            j++;
        }
        
        for(int x=0; x<n; x++) arr[l+x]=temp[x];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna