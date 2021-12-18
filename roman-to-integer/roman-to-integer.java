class Solution {
    public int romanToInt(String s) {
        //map each symbol to value
        //loop through the string
        //if i > 0 and current element > previous element
        //num -= current element - previous element * 2 since we added it twice
        //otherwise num += current element
        //return num
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int num = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            if(i > 0 && map.get(s.charAt(i)) > map.get(s.charAt(i - 1)))
            {
                num += map.get(s.charAt(i)) - map.get(s.charAt(i - 1)) * 2;
            }
            else
            {
                num += map.get(s.charAt(i));
            }
        }
        return num;
    }
}