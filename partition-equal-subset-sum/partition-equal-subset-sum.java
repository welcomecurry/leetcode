class Solution {
    public boolean canPartition(int[] nums) {
        //get sum
        //target is sum / 2
        //init set with inital element 0
        //loop through each number 
        //init temp set
        //loop through tempset
        //if num + setnum == target return true
        //if num + setnum < target add to set
        //if we make it through that means we cannot parition so return false
        
        int sum = 0;
        
        for(int i : nums) sum += i;
        
        if(sum % 2 != 0) return false;
        
        int target = sum / 2;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        
        for(int num : nums)
        {
            Set<Integer> temp = new HashSet<>(set);
            
            for(int i : temp)
            {
                if(num + i == target) return true;
                if(num + i < target) set.add(num + i);
            }
        }
        
        return false;
    }
}