class Solution {
  public:
    void mergeSort(vector<int>& arr, int l, int r) {
        if(l>=r) return;
        
        int mid=l+(r-l)/2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        merge(arr, l, mid, r);
    }
    void merge(vector<int>& arr, int l, int mid, int r)
    {
        int* temp=new int[r-l+1];
        int i=l, j=mid+1, k=0;
        while(i<=mid && j<=r)
        {
            if(arr[i]<=arr[j]) temp[k++]=arr[i++];
            else temp[k++]=arr[j++];
        }
        while(i<=mid) temp[k++]=arr[i++];
        while(j<=r) temp[k++]=arr[j++];
        
        for(i=l, k=0; i<=r; i++, k++) arr[i]=temp[k];
        delete[] temp;
    }
};

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna