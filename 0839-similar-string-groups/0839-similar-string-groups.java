class Solution {
    
    class UnionFind{

        int[] parent;
        int[] rank;
        int count;

        public UnionFind(int n){
            parent = new int[n];
            rank = new int[n];

            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
            count = n;
        }

        public int find(int i){
            if(i == parent[i])
                return i;
            parent[i] = find(parent[i]);
            return parent[i];
        }

        public boolean union(int a, int b){

            int parentA = find(a);
            int parentB = find(b);

            if(parentA == parentB)
                return false;

            if(rank[parentA] <= rank[parentB]){
                parent[parentA] = parentB;
                if(rank[parentA] == rank[parentB])
                    rank[parentB]++;
            }
            else{
                parent[parentB] = parentA;
            }
            count--;
            return true;
        }
    }
    
    public int numSimilarGroups(String[] A) {
        UnionFind uf = new UnionFind(A.length);
        for(int i = 0; i < A.length; i++){
            for(int j = i+1; j < A.length; j++){
                if(uf.count == 1)
                    return 1;
                if(areSimilar(A[i], A[j])){
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }
    
    public boolean areSimilar(String str1, String str2){
        if(str1.length() != str2.length()) return false;
        int differences = 0;
        for(int i = 0; i < str1.length(); i++){
            int c1 = str1.charAt(i), c2 = str2.charAt(i);
            if(c1 != c2){
                if(differences == 2)
                    return false;
                differences++;
            }
        }
        return true;
    }
}