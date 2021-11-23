class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int steps = 0, cap = capacity;
        
        for(int i = 0; i < plants.length; i++)
        {
            if(cap < plants[i])
            {
                cap = capacity; //reset capacity
                steps += i * 2; //steps to go from plant to water source and back to plant
            }
            
            cap -= plants[i]; //water plant
            steps++; //walk to next plant
        }
        
        return steps;
    }
}