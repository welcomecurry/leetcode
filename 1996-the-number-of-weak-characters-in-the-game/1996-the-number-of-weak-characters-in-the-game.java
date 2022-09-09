class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        //sort array based on attack, if the  attacks are the same sort on defense
        //keep a max and beta count
        //since we are looping in decreasing order, as we go down the list we will find candiates that meet the creteria
        
        Arrays.sort(properties, (a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        int max = Integer.MIN_VALUE, betas = 0;
        
        for(int[] character : properties)
        {
            if(max > character[1]) betas++;
            max = Math.max(max, character[1]);
        }
        
        return betas;
    }
}