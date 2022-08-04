class Solution {
    public int mirrorReflection(int p, int q) {
        while(p % 2 == 0 && q % 2 == 0){
            p = p >> 1;
            q = q >> 1;
        }
        return (p % 2 == 1) ? q % 2 : 2;
    }
}