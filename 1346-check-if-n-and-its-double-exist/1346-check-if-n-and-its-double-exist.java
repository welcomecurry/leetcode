class Solution {
    public boolean checkIfExist(int[] arr) {
        //loop through and add all to set
        //loop through again and if set contains num * 2 return true
        //else false
        
        Set<Integer> set = new HashSet<>();
        
        for(int i : arr) 
        {
            if(set.contains(i * 2) || (i % 2 == 0 && set.contains(i / 2))) return true;
            set.add(i);
        }
        
        return false;
    }
}