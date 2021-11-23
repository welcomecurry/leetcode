class Solution {
    public int maxDistance(int[] colors) {
        //brute force
        
        int distance = 0;
        
        for(int i = 0; i < colors.length; i++)
        {
            for(int j = i + 1; j < colors.length; j++)
            {
                if(colors[i] != colors[j])
                {
                    distance = Math.max(distance, j - i);
                }
            }
        }
        
        return distance;
    }
}