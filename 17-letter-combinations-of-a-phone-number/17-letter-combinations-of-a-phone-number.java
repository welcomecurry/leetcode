class Solution {
    Map<Character, String> digitMap = new HashMap<>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    public List<String> letterCombinations(String digits) {
        List<String> output = new ArrayList<>();
        
        if(digits.length() == 0) return output;
        
        backtrack(output, digits, new StringBuilder(), 0);
        
        return output;
    }
    
    private void backtrack(List<String> output, String digits, StringBuilder curr, int index)
    {
        //base case, if the sb length == digits.length append to output
        //else grab current digit digit.charAt(index)
        //loop through letters and make choice and append char at letters
        //backtrack on index + 1 and undo choice by removing last character
        
        if(curr.length() == digits.length())
        {
            output.add(curr.toString());
            return;
        }
        
        String letters = digitMap.get(digits.charAt(index));
        
        for(int i = 0; i < letters.length(); i++)
        {
            curr.append(letters.charAt(i));
            backtrack(output, digits, curr, index + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}