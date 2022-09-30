class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res=new ArrayList<>();
        List<int[]> heights=new ArrayList<>();
        
        transform(buildings,heights);
        Collections.sort(heights,(a,b) -> (a[0]==b[0]) ? a[1] -b[1] : a[0] -b[0]); 
        
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>((a,b) -> (b-a));
        pq.offer(0);
        
        int premax=0;
        for(int []h:heights)
        {
            if(h[1]<0)
            {
                pq.offer(-h[1]);
            }
            else{
                pq.remove(h[1]);
            }
            int currmax=pq.peek();
            if(currmax!=premax)
            {
                List<Integer> l=new ArrayList<>();
                l.add(h[0]);
                l.add(currmax);
                res.add(l);
                premax=currmax;
            }
        }
        return res;
    }
   private void transform(int[][] buildings,List<int[]>heights)
      {
       for(int []b:buildings)
       {
           heights.add(new int[] {b[0],-b[2]});
            heights.add(new int[] {b[1],b[2]});
       }
      }
}