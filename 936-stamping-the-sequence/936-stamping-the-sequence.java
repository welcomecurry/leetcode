class Solution {
    public int[] movesToStamp(String stamp, String target) {
        //instead of starting at all ???? start from target and work backwards to all ???
        //init char arrays of stamp and target
        //init a stack since we want our result in reverse when we return at the end
        //init a count and a boolean array to keep track of the places we visited
        //loop through while count != target.length
        //loop from 0 to target.length - stamp.length
        //if our current element has not been visted and we can replace substring with ?
        //replace the substring with all ?, set to visited and mark that we changed the string
        //if count == target.length we have reached the end so break out of loop
        //if for current iteration we did not change to ? then return emmpty array, since not possible
        
        char[] s = stamp.toCharArray();
        char[] t = target.toCharArray();
        boolean[] visited = new boolean[target.length()];
        List<Integer> list = new ArrayList<>();
        int count = 0;
        
        while(count != t.length)
        {
            boolean changed = false;
            
            for(int i = 0; i <= t.length - s.length; i++)
            {
                if(!visited[i] && canReplace(s, t, i))
                {
                    count = replace(t, i, s.length, count);
                    visited[i] = true;
                    changed = true;
                    list.add(i);
                }
                
                if(count == t.length) //entire string is ?
                {
                    break;
                }
            }
                            
            if(!changed) //for current iteration if we did not change the string
            {
                return new int[0];
            }
        }
        
        int[] output = new int[list.size()];
        int k = 0;
        
        for(int i = list.size() - 1; i >= 0; i--)
        {
            output[k++] = list.get(i);
        }
        
        return output;
    }
    
    private boolean canReplace(char[] s, char[] t, int pos)
    {
        for(int i = 0; i < s.length; i++)
        {
            if(t[i + pos] != '?' && t[i + pos] != s[i]) //if char is not ? and chars dont match
            {
                return false; //we cannot replace so return false;
            }
        }
        return true;
    }
    
    private int replace(char[] t, int pos, int length, int count)
    {
        for(int i = 0; i < length; i++)
        {
            if(t[i + pos] != '?')
            {
                t[i + pos] = '?';
                count++;
            }
        }
        
        return count;
    }
}