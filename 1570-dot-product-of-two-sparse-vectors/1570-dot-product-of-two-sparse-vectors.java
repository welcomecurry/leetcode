class SparseVector {
    int[] vector;
    SparseVector(int[] nums) {
        vector = nums;
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int prod = 0, index = 0;
        
        while(index < vector.length) {
            prod += vector[index] * vec.vector[index];
            index++;
        }
        
        return prod;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);