class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        //init decrease amount
        //sort
        //while k > 0
        //increment decrease amt and happiness - decrease amount
        
        long dec = 0, total = 0;
        
        Arrays.sort(happiness);
        int i = happiness.length - 1;

        while(i >= 0 && k > 0) {
            long diff = Math.max(0, happiness[i] - dec);
            total += diff;
            k--;
            dec++;
            i--;
        }
        
        return total;
    }
}