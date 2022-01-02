class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        //greedy
        //sort asteroids and keep adding while mass >= asteroids[i]
        
        long mas = mass;
        Arrays.sort(asteroids);
        
        for(int asteroid : asteroids)
        {
            if(mas < asteroid) 
            {
                return false;
            }
            mas += asteroid;
        }
        
        return true;
    }
}