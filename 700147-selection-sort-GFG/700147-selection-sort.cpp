class Solution {
  public:
    void selectionSort(vector<int> &arr) {
        int n=arr.size();
        int minIndex;
        for(int i=0; i<n; i++)
        {
            minIndex=i;
            for(int j=i+1; j<n; j++)
            {
                if(arr[j]<arr[minIndex]) minIndex=j;
            }
            int temp=arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;
        }
    }
};

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna