class Solution {
    public int maximum69Number (int num) {
        //create string builder 
        //add num to string builder
        //loop through string builder
        //if current char != 9 
        // set it to 9 and break out of loop
        //return Integer.parseInt(sb.toString())
        
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        
        for(int i = 0; i < sb.length(); i++)
        {
            if(sb.charAt(i) != '9')
            {
                sb.setCharAt(i, '9');
                break;
            }
        }
        
        return Integer.parseInt(sb.toString());
    }
}