class Solution {
    public int countSeniors(String[] details) {
        //extract indices 11 && 12 if number > 60 increment
        int seniors = 0;
        
        for(String person : details) {
            if(Integer.parseInt(person.substring(11, 13)) > 60) seniors++;
        }
        
        return seniors;
    }
}