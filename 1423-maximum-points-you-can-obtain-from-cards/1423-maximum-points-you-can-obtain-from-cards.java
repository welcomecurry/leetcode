class Solution {
    public int maxScore(int[] cardPoints, int k) {
        //get sum of cardPoints
        //loop through n - k windows and max is max, points - sumOfCurrentWindow
        
        int points = 0, max = 0, window = 0;
        
        for(int i : cardPoints)
        {
            points += i;
        }
        
        if(cardPoints.length == k) return points; //Case [2,2,2]  k = 3
        
        for(int i = 0; i < cardPoints.length - k - 1; i++) //grab initial n - k window
        {
            window += cardPoints[i];
        }
        
        for(int i = cardPoints.length - k - 1; i < cardPoints.length; i++) //calc remaining windows
        {
            window += cardPoints[i]; //expand window
            max = Math.max(max, points - window); //total_pts - sumOfCurrentWindow
            window -= cardPoints[i - (cardPoints.length - k - 1)]; //move left side of window over
        }
        
        return max;
    }
}