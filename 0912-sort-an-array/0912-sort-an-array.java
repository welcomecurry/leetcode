class Solution {
    public int[] sortArray(int[] nums) {
        //merge sort
        //call mergeSort(nums, 0, nums.length - 1)
        //return nums
        
        mergeSort(nums, 0, nums.length - 1);
        
        return nums;
    }
    
    public void mergeSort(int[] arr, int low, int high) {
        //if low < high 
        //int mid = low + (high - low) / 2
        //split into 2 halves from 0 to mid and mid + 1 to high
        //recurse 0 to  mid
        //recurse mid + 1 to high
        //merge(arr, low, mid, high)
        
        if(low < high)  {
            int mid = low + (high - low) / 2;
        
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
        
            merge(arr, low, mid, high);
        }
    }
    
    public void merge(int[] arr, int low, int middle, int high) {
        //get sizes of left and right temp arrays
        //left = mid - low + 1 => right = high - mid
        //create temp arrays with those sizes
        //populate left array with arr[low + i]
        //popultae right array with arr[mid + 1 + i]
        //create 3 pointers, i => leftIndex, j => rightIndex, k => low
        //while i < leftTempSize && j < rightTempSize
        //if left[i] <= right[j] => arr[k] = left[i] i++
        //else arr[k] = right[j] j++
        //k++
        //check if there are remaining elements in both temp arrays
        //while i < lefttempsize => arr[k] = left[i] i++ k++
        //while j < rightTempSize => arr[k] = right[j] j++ k++
        
        int leftTempSize = middle - low + 1;
        int rightTempSize = high - middle;
        
        int[] leftTemp = new int[leftTempSize];
        int[] rightTemp = new int[rightTempSize];
        
        for(int i = 0; i < leftTemp.length; i++) {
            leftTemp[i] = arr[low + i]; //at low + currentIndice
            //low doesnt change thats why we add i
        }
        
        for(int j = 0; j < rightTemp.length; j++) {
            rightTemp[j] = arr[middle + 1 + j]; //at middle + currentIndice
            //middle does not change thats why we add j
        }
        
        int i = 0;
        int j = 0;
        int k = low;
        
        while(i < leftTempSize && j < rightTempSize) {
            if(leftTemp[i] <= rightTemp[j]) {
                arr[k] = leftTemp[i];
                i++;
            } else {
                arr[k] = rightTemp[j];
                j++;
            }
    
            k++;
        }
        
        while(i < leftTempSize) {
            arr[k] = leftTemp[i];
            i++;
            k++;
        }
        
        while(j < rightTempSize) {
            arr[k] = rightTemp[j];
            j++;
            k++;
        }
    }
}