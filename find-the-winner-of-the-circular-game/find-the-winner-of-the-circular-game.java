class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 1; i <= n; i++)
        {
            list.add(i);
        }
        
        int circular = 0;
        
        while(list.size() > 1)
        {
            circular = (circular + (k - 1)) % list.size();
            list.remove(circular);
        }
        
        return list.get(0);
    }
}