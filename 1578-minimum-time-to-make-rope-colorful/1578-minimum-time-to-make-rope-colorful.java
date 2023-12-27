class Solution {
    public int minCost(String s, int[] cost) {
        int ans = 0, n = s.length();
        for(int l = 0, r = 1; r < n; ){
            if(s.charAt(l) != s.charAt(r)){
                l = r; 
                r++;
                continue;
            }
            
            if(cost[l] <= cost[r]){
                ans += cost[l];
                l = r; 
                r++;
            }
            
            else if(cost[l] > cost[r]){
                ans += cost[r];
                r++;
            }
        }
        
        return ans;
    }
}