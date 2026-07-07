class Solution {
    public void quickSort(int[] arr, int low, int high) 
    {
        if(low>=high) return;
        
        int pivot_idx=partition(arr, low, high);
        quickSort(arr, low, pivot_idx-1);
        quickSort(arr, pivot_idx+1, high);
    }

    private int partition(int[] arr, int low, int high) 
    {
        int pivot=arr[high];
        int pivot_idx=low;
        for(int i=low; i<high; i++)
        {
            if(arr[i]<pivot)
            {
                swap(arr, pivot_idx, i);
                pivot_idx++;
            }
        }
        swap(arr, pivot_idx, high);
        return pivot_idx;
    }
    private void swap(int[] arr, int i, int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna