class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        
        Arrays.sort(idx, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return startTime[b] - startTime[a];
            }
        });
        
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        
        for (int i = 0; i < n; i++) {
            int maxProfit = 0;
            Map.Entry<Integer,Integer> entryStart = map.ceilingEntry(startTime[idx[i]]);
            if (entryStart != null) maxProfit = entryStart.getValue();
            
            Map.Entry<Integer,Integer> entryEnd = map.ceilingEntry(endTime[idx[i]]);
            maxProfit = Math.max(maxProfit, profit[idx[i]] + (entryEnd == null ? 0 : entryEnd.getValue()));
            
            map.put(startTime[idx[i]], maxProfit);
        }
        
        return map.firstEntry().getValue();
    }
}