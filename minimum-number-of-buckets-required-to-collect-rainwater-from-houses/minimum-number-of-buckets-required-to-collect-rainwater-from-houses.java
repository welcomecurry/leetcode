class Solution {
    public int minimumBuckets(String street) {
        //init buckets
        //init stringbuider of street so we can modify the characters
        //loop through string
        //check if the current element is a house
        //if the previous element is in bounds and the prev element has been visited continue
        //if the prev elemenet is in bounds and is a space increment buckest
        //if the next element is in bounds and is a space increment bucket and set as visited
        //otherwise there are two adjacent houses to current house thus no collection return -1
        
        int buckets = 0;
        StringBuilder s = new StringBuilder(street);
        
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == 'H')
            {
                if(i - 1 >= 0 && s.charAt(i - 1) == 'X')
                {
                    continue;
                }
                else if(i + 1 < s.length() && s.charAt(i + 1) == '.')
                {
                    buckets++;
                    s.setCharAt(i + 1, 'X');
                }
                else if(i - 1 >= 0 && s.charAt(i - 1) == '.')
                {
                    buckets++;
                }
                else //.HHH. condiiton
                {
                    return -1;
                }
            }
        }
        
        return buckets;
    }
}