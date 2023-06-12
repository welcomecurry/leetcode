class Solution {
    public List<String> summaryRanges(int[] nums) {
        //create result list
        //base check
        //loop through nums
        //set start to current element
        //while i + 1 < length and nums[i + 1] = nums[i] + 1
            //i++
        //i is being incremented in the while loop so when we hit the end of for loop we are at the end of last    valid range
        //if  start != nums[i]
            //add current start and i to result
        //else 
            //result add start
        //return result at the end
        
        List<String> result = new ArrayList<>();
        if(nums.length == 0)
        {
            return result;
        }
        
        for(int i = 0; i < nums.length; i++)
        {
            int start = nums[i];
            while(i + 1 < nums.length && nums[i + 1] == nums[i] + 1)
            {
                i++;
            }
            
            if(start != nums[i])
            {
                result.add(start + "->" + nums[i]);
            }
            else
            {
                result.add("" + start);
            }
        }
        
        return result;
    }
}