class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        //dynamic programming
        //init output
        //init left and right
        //left is to track decreasing element count from the left 
        //right is to track the incrdeasing element count from the right
        //loop starting at time and end at length - time
        //if the left and right counts are > time then we have satisfied the condition
        
        List<Integer> daysToRob = new ArrayList<>();
        int[] left = new int[security.length], right = new int[security.length];
        
        for(int i = 1; i < left.length; i++)
        {
            left[i] = security[i] <= security[i - 1] ? left[i - 1] + 1 : 0; 
                                                    //increase or break count
        }
        
        for(int i = security.length - 2; i >= 0; i--)
        {
            right[i] = security[i] <= security[i + 1] ? right[i + 1] + 1 : 0; 
                                                    //increase or break count
        }
        
        for(int i = time; i < security.length - time; i++)
        {
            if(left[i] >= time && right[i] >= time) daysToRob.add(i);
        }
        
        return daysToRob;
    }
}