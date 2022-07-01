class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        //sort numOfUnits in decreasing order
        //init maxUnits
        //loop through boxTypes, if maxUnits + numBoxes <= trucksize
        //add maxUnits
        //otherwise take the difference and break
        //return maxUnits
        
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
        
        int maxUnits = 0;
        
        for(int[] box : boxTypes)
        {
            if(truckSize >= box[0])
            {
                maxUnits += box[0] * box[1];
                truckSize -= box[0];
            }
            else
            {
                maxUnits += truckSize * box[1]; //remaining size * current units
                break; //no more space in truck so break
            }
        }
        
        return maxUnits;
    }
}