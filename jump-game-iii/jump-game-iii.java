class Solution {
    public boolean canReach(int[] arr, int start) {
        //dfs
        return dfs(arr, start);
    }
    
    private boolean dfs(int[] arr, int start)
    {
        //base case if we are not in bounds or we have visited current position return false
        //if we are on a 0 return true
        //mark current element as visited by turning negative
        //otherwise return if start + arr[start] or start - arr[start] is true
        
        if(start < 0 || start >= arr.length || arr[start] < 0) return false;
        
        if(arr[start] == 0) return true;
        
        arr[start] *= -1; //mark current position as visited
        
        return dfs(arr, start + arr[start]) || dfs(arr, start - arr[start]);
    }
}