class Solution {
    
    List<Integer> res;
    public int[] numsSameConsecDiff(int n, int k) {
        res = new ArrayList<>();
        
        for(int i = 1; i < 10; i++)
            findNums(i, n - 1, k);
        
        return res.stream().mapToInt(i->i).toArray();
    }
    
    
    private void findNums(int num, int len, int k){
        
        if(len == 0)
            res.add(num);
        
        else{
            
            int lastDigit = num % 10;
            int nextDigit = lastDigit + k;
            int prevDigit = lastDigit - k;
            
            if(nextDigit < 10)
                findNums(num * 10 + nextDigit, len -1, k);
            
            if(prevDigit != nextDigit && prevDigit >= 0)
                findNums(num * 10 + prevDigit, len -1, k);
        }
    }
}