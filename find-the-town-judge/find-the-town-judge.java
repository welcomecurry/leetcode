class Solution {
    public int findJudge(int n, int[][] trust) {
        //create an array of everybody
        //decrement a and increment b
        //loop through trused and current element == n - 1 return i
        //return -1 if no judge
        
        int[] isTrusted = new int[n + 1];
        
        for(int[] person : trust)
        {
            isTrusted[person[0]]--;
            isTrusted[person[1]]++;
        }
        
        for(int i = 1; i < isTrusted.length; i++)
        {
            if(isTrusted[i] == n - 1) return i;
        }
        
        return -1;
    }
}