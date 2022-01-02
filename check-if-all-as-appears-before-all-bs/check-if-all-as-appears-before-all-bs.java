class Solution {
    public boolean checkString(String s) {
        //just check if its sorted
        char[] sorted = s.toCharArray();
        Arrays.sort(sorted);
        return Arrays.equals(s.toCharArray(), sorted);
    }
}