class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b)->a[0]==b[0]?a[1]-b[1]:b[0]-a[0]);
        List<int[]> output = new LinkedList<>();
        for( int[] p : people) {
            System.out.println(Arrays.toString(p));
            output.add(p[1] , p);     
        }
        return output.toArray(new int[people.length][2]);
    }
}