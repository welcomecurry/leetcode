class Solution {
    public int minSteps(String s, String t) {
        //loop through and count occurences of both s and t
        //loop through alphabet and sum the differnces of strings
        
        int steps = 0;
        
        Map<Character, Integer> sMap = new HashMap<>(), tMap = new HashMap<>();
        
        for(char c : s.toCharArray()) sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        
        for(char c : t.toCharArray()) tMap.put(c, tMap.getOrDefault(c, 0) + 1);

        
        for(int i = 'a'; i <= 'z'; i++)
        {
            int currS = sMap.getOrDefault((char) i, 0), currT = tMap.getOrDefault((char) i, 0);
            steps += Math.max(currS, currT) - Math.min(currS, currT);
        }
        
        return steps;
    }
}