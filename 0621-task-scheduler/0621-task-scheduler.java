class Solution {
    public int leastInterval(char[] tasks, int n) {
        //create charmap from the task arr
        //sort them since we want to get most frequent element
        //init maxVal = last element - 1, which is max element and subtracting 1 since there is no idle after last task
        //init idleSpots = maxVal * n
        //loop through charMap starting from end
        //idleSpots -= min of maxVal and current element
        //if idlespots < 0 return tasks.length otherwise return idlespots + length
        
        int[] charMap = new int[26];
        
        for(char c : tasks) charMap[c - 'A']++;
        
        Arrays.sort(charMap);
        int maxVal = charMap[25] - 1; //-1 we bc don't have to idle after last task
        int idleSpots = maxVal * n;
        
        for(int i = 24; i >= 0; i--) {
            idleSpots -= Math.min(maxVal, charMap[i]);
        }
        
        return idleSpots < 0 ? tasks.length : idleSpots + tasks.length;
    }
}