class Solution {
    public int maxProduct(String[] words) {
        //create list of sets
        //loop through words.length 
        //add a new set for each word
        //loop through each word and chars to set
        //loop through again
        //create temp arraylist out of ith element
        //temp.retainAll
        //if temp length is 0, => no common letters
        //take max of max and product of lengths
        //return max
        
        List<Set<Character>> listset = new ArrayList<>();
        int max = 0;
        
        for(int i = 0; i < words.length; i++)
        {
            listset.add(new HashSet<>());
        }
        
        for(int i = 0; i < words.length; i++)
        {
            for(char c : words[i].toCharArray())
            {
                listset.get(i).add(c);
            }
        }
        
        for(int i = 0; i < words.length; i++)
        {
            for(int j = i + 1; j < words.length; j++)
            {
                HashSet<Character> intersection = new HashSet<>(listset.get(i));
                intersection.retainAll(listset.get(j));
                
                if(intersection.size() == 0)
                {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        
        return max;
    }
}