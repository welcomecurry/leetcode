class Solution {
    public String convert(String s, int numRows) {
        //simulate
        //init 2d array
        //insert num row letters
        //then row - 2 letters
        //repeat
        
        List<List<Character>> list = new ArrayList<>();
        
        for(int i = 0; i < numRows; i++) list.add(new ArrayList<>());
        
        int index = 0;
        
        while(index < s.length()) {
            //insert num row letters, move down
            for(int i = 0; i < numRows; i++) {
                if(index >= s.length()) break;
                list.get(i).add(s.charAt(index++));
            }
            
            //move up diagonally
            for(int i = numRows - 2; i > 0; i--) {
                if(index >= s.length()) break;
                list.get(i).add(s.charAt(index++));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < list.size(); i++) {
            for(int j = 0; j < list.get(i).size(); j++) {
                sb.append(list.get(i).get(j));
            }
        }
        
        return sb.toString();
    }
}