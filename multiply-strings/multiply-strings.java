class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        
        int[] output = new int[num1.length() + num2.length()];
        
        for(int i = num1.length() - 1; i >= 0; i--)
        {
            for(int j = num2.length() - 1; j >= 0; j--)
            {
                int valueIndex = i + j + 1;
                int remainderIndex = i + j;
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                
                product += output[valueIndex];
                output[valueIndex] = product % 10;
                output[remainderIndex] += product / 10;
            }
        }
        
        boolean proceedingZeros = true;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < output.length; i++)
        {
            int val = output[i];
            if(val != 0) proceedingZeros = false;
            if(!proceedingZeros) sb.append(val);
        }
        
        return sb.toString();
    }
}