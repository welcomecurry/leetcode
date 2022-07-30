class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        //init output
        //init count of B
        //loop through strings of B
        //bCount[c - 'a'] = max of bcount and temp count
        //loop thorugh each string in A
        //count characters for currWord
        //call helper, if currWord and bCount are subsets, add to output
        //return output
        
        List<String> output = new ArrayList<>();
        int[] bCount = new int[26];
        
        for(String sub : B)
        {
            int[] temp = new int[26];
            
            for(char c : sub.toCharArray())
            {
                temp[c - 'a']++;
                //eg we have a string "oo" we have to get o twice
                bCount[c - 'a'] = Math.max(bCount[c - 'a'], temp[c - 'a']);
            }
        }
        
        for(String word : A)
        {
            int[] currWord = new int[26];
            for(char c : word.toCharArray()) currWord[c - 'a']++;
            
            if(isSubset(currWord, bCount))
            {
                output.add(word);
            }
        }
        
        return output;
    }
    
    private boolean isSubset(int[] currWord, int[] bCount)
    {
        //loop through from 0 to 26
        //if bCount has a count > currWord, it is not a subset so return false
        //if we make it through loop it is a subset so return true
        
        for(int i = 0; i < 26; i++)
        {
            if(bCount[i] > currWord[i])
            {
                return false;
            }
        }
        
        return true;
    }
}