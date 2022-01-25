class Solution {
    public boolean validMountainArray(int[] arr) {
        //base check if arr.length. < 3 return false
        //keep pointer to see increasing and pointer for decrease and see if they equal at end
        
        if(arr.length < 3) return false;
        
        int increase = 0, decrease = arr.length - 1;
        
        while(increase + 1 < arr.length - 1 && arr[increase + 1] > arr[increase]) increase++;
        
        while(decrease - 1 > 0 && arr[decrease - 1] > arr[decrease]) decrease--;
        
        return increase == decrease;
    }
}