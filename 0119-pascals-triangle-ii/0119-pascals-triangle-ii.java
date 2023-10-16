class Solution {
    public List<Integer> getRow(int rowIndex) {
        //init triangle 2D list
        //add first row to 2D list
        //if rowIndex == 0 reuturn triangle
        //loop through from 1 to rowIndex, 1 since we already added first row\
        // + 1 since the row Index that wants to be returned is zero indexed
        //init prevRow to retrieve sums
        //init currRow to add to list
        //add 1 to currRow since every row starts with a one
        //loop through from 1 to i
        //add the sum of the prev elements and add to currRow, j + j - 1
        //add 1 to currRow since every row ends with a one
        //add currRow to triangle
        //return triangle.get(rowIndex)
        
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(1));
        
        if(rowIndex == 0) return triangle.get(rowIndex);
        
        for(int i = 1; i <= rowIndex; i++)
        {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> currRow = new ArrayList<>();
            
            currRow.add(1);
            
            for(int j = 1; j < i; j++)
            {
                currRow.add(prevRow.get(j) + prevRow.get(j - 1));
            }
            
            currRow.add(1);
            
            triangle.add(currRow);
        }
        
        return triangle.get(rowIndex);
    }
}