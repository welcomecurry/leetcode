class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.putIfAbsent(s.charAt(i), t.charAt(i)) != null) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }
            if (map2.putIfAbsent(t.charAt(i), s.charAt(i)) != null) {
                if (map2.get(t.charAt(i)) != s.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}