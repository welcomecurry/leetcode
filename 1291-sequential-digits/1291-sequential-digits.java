class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        //create an arraylist to hold the sequentialDigits
        //create a string and take the substring and add to string depending on locarion in loops
        //create two loops i = 2 j = 0; j <= digits.length() - i
        //if Integer.parseInt(digits.substring(j, j + i) >= low) add to arraylist from j to j + length
        // else if > high return list
        
        List<Integer> sequences = new ArrayList<>();
        String digits = "123456789";
        
        for(int i = 2; i <= digits.length(); i++)
        {
            for(int j = 0; j <= digits.length() - i; j++)
            {
                int num = Integer.parseInt(digits.substring(j, j + i));
                
                if(num > high) return sequences;
                
                if(num >= low) sequences.add(num);
            }
        }
        
        return sequences;
    }
}