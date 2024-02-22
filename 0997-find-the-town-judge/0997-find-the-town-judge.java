class Solution {
    public int findJudge(int n, int[][] trust) {
        //treat as directed graph, basically counting the indegrees of each person
        //create an array of everybody
        //decrement ai and increment bi
        //loop through trusted if current element == n - 1 return i, (indegree is n - 1)
        //return -1 if no judge
        
        int[] isTrusted = new int[n + 1];
        
        for(int[] person : trust) {
            isTrusted[person[0]]--; //person trusts someone
            isTrusted[person[1]]++; //person is trusted by someone
        }
        
        for(int i = 1; i < isTrusted.length; i++) {
            if(isTrusted[i] == n - 1) return i; //n - 1 since everyone trusts town judge except self
        }
        
        return -1;
    }
}