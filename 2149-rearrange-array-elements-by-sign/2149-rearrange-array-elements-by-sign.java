class Solution {
    public int[] rearrangeArray(int[] nums) {
        //add all positve and negative elements to an array
        //create output and alternate appending to output
        //we can alternate because the arrays is even
        
        List<Integer> positive = new ArrayList<>(), negative = new ArrayList<>();
        int[] output = new int[nums.length];
        
        for(int num : nums)
        {
            (num > 0 ? positive : negative).add(num);
        }
        
        for(int i = 0; i < nums.length / 2; i++)
        {
            output[i * 2] = positive.get(i);
            output[(i * 2) + 1] = negative.get(i);
        }
    
        return output;
    }
}