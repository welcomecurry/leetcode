class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        //sort both arrays
        //we need to find the widest and tallest cuts
        
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        long widest = findMax(horizontalCuts, h);
        long tallest = findMax(verticalCuts, w);
        
        return (int) ((widest * tallest) % 1000000007);
    }
    
    private long findMax(int[] cuts, int total)
    {
        long max = 0, prev = 0;
        
        for(int cut : cuts)
        {
            max = Math.max(max, cut - prev);
            prev = cut;
        }
        
        max = Math.max(max, total - prev);
        
        return max;
    }
}