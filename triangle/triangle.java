class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //dynamic programming top down, same as minimum path sum
        //loop thorugh starting at one
        //we need to compute the left most and right most cells with the previous elements
        //if we are on first element then add curr element with i - 1
        //if we are on last element then add curr element with i - 1 last element
        //otherwise if we are in middle elements there are two possible options to compute sum
        //for current element, so select the minimum
        //after checks, set element to the sum
        //then return the minimum element in the last row
        
        for(int i = 1; i < triangle.size(); i++)
        {
            for(int j = 0; j < triangle.get(i).size(); j++)
            {
                int currSum = 0;
                
                if(j == 0)
                {
                    currSum = triangle.get(i).get(j) + triangle.get(i - 1).get(j);    
                }
                else if(j == triangle.get(i).size() - 1)
                {
                    currSum = triangle.get(i).get(j) + triangle.get(i - 1).get(triangle.get(i - 1).size() - 1); 
                }
                else
                {
                    int minElement = Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1));
                    currSum = minElement + triangle.get(i).get(j);
                }
                
                triangle.get(i).set(j, currSum);
            }
        }
        
        return Collections.min(triangle.get(triangle.size() - 1));
    }
}