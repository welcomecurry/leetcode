class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        //loop thorugh and check if current previous and next elements are 0, decrement n
        //return n == 0
        
        for(int i = 0; i < flowerbed.length; i++)
        {
            if(flowerbed[i] == 1) continue;
            
            int prev = i == 0 ? 0 : flowerbed[i - 1]; //if prev out of bounds return 0
            int next = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1]; //if next OTB return 0
            
            if(prev == 0 && next == 0)
            {
                flowerbed[i] = 1; //place flower
                n--; //decrement flowers
            }
        }
        
        return n <= 0;
    }
}