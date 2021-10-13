class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        if(denominator == 0) return "";
        
        StringBuilder sb = new StringBuilder();
        boolean negative = (numerator < 0) ^ (denominator < 0);
        
        long top = Math.abs(numerator);
        long bottom = Math.abs(denominator);
        top = Math.abs(top);
        bottom = Math.abs(bottom);
        
        long result = top / bottom;
        long remainder = (top % bottom) * 10;
        
        if(negative) sb.append("-");
        sb.append(result);
        if(remainder != 0) sb.append(".");
        
        Map<Long, Integer> map = new HashMap<>();
        
        while(remainder != 0)
        {
            if(map.containsKey(remainder))
            {
                sb.insert(map.get(remainder), "(");
                sb.append(")");
                break;
            }
            
            map.put(remainder, sb.length());
            result = remainder / bottom;
            sb.append(result);
            remainder = (remainder % bottom) * 10;
        }
        
        return sb.toString();
    }
}