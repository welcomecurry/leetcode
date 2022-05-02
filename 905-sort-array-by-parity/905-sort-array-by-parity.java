class Solution {
    public int[] sortArrayByParity(int[] A) {
        // have pointer at 0
        // if A[i] % 2 == 0 
        // swap a[pointer] = a[i]
        // a[i] = a[pointer]
        // pointer++;
        int pointer = 0;
        
        for(int i = 0; i < A.length; i++)
        {
            if(A[i] % 2 == 0)
            {
                int temp = A[i];
                A[i] = A[pointer];
                A[pointer] = temp;
                pointer++;
            }
        }
        return A;
    }
}