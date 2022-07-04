class Solution {
    public int candy(int[] ratings) {
        //create res array that is filled with ones
        //check rating from left to right, if curr element > prev element res[i] = res[i - 1] + 1
        //check rating from right ot left, if curr element > next element res[i] = res[i + 1] + 1
        //if it is compare res
        //return sum of res
        
        int[] res = new int[ratings.length];
        Arrays.fill(res, 1);
        
        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i - 1]) {
                res[i] = res[i - 1] + 1;
            }
        }
        
        for(int i = ratings.length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) {
                if(res[i] <= res[i + 1]) {
                    res[i] = res[i + 1] + 1;
                }
            }
        }
        
        return Arrays.stream(res).sum();
    }
}