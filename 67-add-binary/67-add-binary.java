class Solution {
    public String addBinary(String a, String b) {
        //init string builder
        //init carry and a and b pointers starting at end of string
        //loop while both pointers are in bounds
        //if a is in bounds, += number
        //if b is in bounds, += number
        //append sum % 2 if the sum is 2 append 0, since 1 + 1 = 0
        //carry = sum / 2
        //if we have a remaining carry append it
        //return sb reversed since its in reverse order
        
        StringBuilder sb = new StringBuilder();
        int aPointer = a.length() - 1, bPointer = b.length() - 1;
        int carry = 0;
        
        while(aPointer >= 0 || bPointer >= 0)
        {
            int sum = carry;
            
            if(aPointer >= 0) sum += a.charAt(aPointer--) - '0';
            
            if(bPointer >= 0) sum += b.charAt(bPointer--) - '0';
            
            sb.append(sum % 2);
            carry = sum / 2;
        }
        
        if(carry != 0)
        {
            sb.append(carry);        
        }
        
        return sb.reverse().toString();
    
    }
}