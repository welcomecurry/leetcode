class Solution {
    public int maxCoins(int[] piles) {
        //greedy
        //sort and give bob all the middle values
        //the first n/3 numbers are bobs and n/3 till the end alternate as MLMLML
        
        Arrays.sort(piles);
        
        int myPile = 0;
        
        for(int i = piles.length / 3; i < piles.length; i += 2) myPile += piles[i];
        
        return myPile;
    }
}