class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        //simulation
        //keep left and right pointers
        //loop while left < right and run simulation
        //return refillsA + refillsB
        
        int left = 0, right = plants.length - 1;
        int currA = capacityA, currB = capacityB, refillsA = 0, refillsB = 0;
        
        while(left <= right)
        {
            if(left == right)
            {
                if(plants[left] > Math.max(currA, currB))
                {
                    refillsA++;
                }
                break; //end simulation since we are on last element
            }
            
            if(currA - plants[left] < 0)
            {
                refillsA++;
                currA = capacityA;
                currA -= plants[left];
            }
            else
            {
                currA -= plants[left];
            }

            if(currB - plants[right] < 0)
            {
                refillsB++;
                currB = capacityB;
                currB -= plants[right];
            }
            else
            {
                currB -= plants[right];
            }
            left++;
            right--;
        }
        
        return refillsA + refillsB;
    }
}