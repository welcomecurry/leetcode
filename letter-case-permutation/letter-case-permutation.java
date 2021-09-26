class Solution {
    public List<String> letterCasePermutation(String S) {
        //backtracking
        //init result
        //call helper passing in, result, S, currString and index
        //return result
        
        List<String> result = new ArrayList<>();
        backtrack(result, S, "", 0);
        return result;
    }
    
    private void backtrack(List<String> result, String S, String currString, int index)
    {
        //base case if if index == S.length(), we found a permutation so add to result and return
        //if the current char is a letter, there are two ways, to permute, lowercase and uppercase
        //otherwise if it is a number just append and increment index
        //everytime we find a letter, we do both case permuatations, lowercase and uppercase
        
        if(index == S.length())
        {
            result.add(currString);
            return;
        }
        
        char currChar = S.charAt(index);
        
        if(Character.isLetter(currChar))
        {
            backtrack(result, S, currString + Character.toLowerCase(currChar), index + 1); //lower
            backtrack(result, S, currString + Character.toUpperCase(currChar), index + 1); //upper
        }
        else //currChar is a digit
        {
            backtrack(result, S, currString + currChar, index + 1);
        }
    }
}