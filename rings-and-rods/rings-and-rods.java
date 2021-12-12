class Solution {
    public int countPoints(String rings) {
        //loop through and map each rod to array of colors, [0]red, [1]green, [2]blue
        //loop through array and count each rod that has every color > 0
        
        Map<Integer, int[]> map = new HashMap<>();
        
        for(int i = 0; i < rings.length() - 1; i+=2)
        {
            char color = rings.charAt(i); 
            int rod = Integer.parseInt(String.valueOf(rings.charAt(i + 1)));
            
            map.computeIfAbsent(rod, r -> new int[3]);
            
            if(color == 'R') map.get(rod)[0]++;
            else if(color == 'G') map.get(rod)[1]++;
            else if(color == 'B') map.get(rod)[2]++;
        }
        
        int res = 0;
        
        for(Map.Entry<Integer, int[]> entry : map.entrySet())
        {
            int[] colors = entry.getValue();
            
            if(colors[0] > 0 && colors[1] > 0 && colors[2] > 0) res++;
        }
        
        return res;
    }
}