class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        //loop thorugh all digits in nums and change digit mapping
        //add the index and the result number to minHeap
        //sort based on value, if they are equal sort by index
        //poll off heap to create ouptut
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
        
        for(int i = 0; i < nums.length; i++)
        {
            minHeap.add(new int[] { nums[i], newMapping(nums[i], mapping), i });
        }
        
        int index = 0;
        
        while(!minHeap.isEmpty()) 
        {
            nums[index++] = minHeap.poll()[0];
        }
        
        return nums;
    }
    
    private int newMapping(int num, int[] mapping)
    {
        if(num == 0) return mapping[num];
        
        StringBuilder sb = new StringBuilder();
        
        while(num > 0)
        {
            sb.append(mapping[num % 10]);
            num /= 10;
        }
        
        return Integer.parseInt(sb.reverse().toString());
    }
}