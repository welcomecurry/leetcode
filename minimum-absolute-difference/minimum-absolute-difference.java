class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        //sort array
        //use treemap to map differences to array of elements
        //return first key elements
        
        Arrays.sort(arr);
        TreeMap<Integer, List<List<Integer>>> map = new TreeMap<>();
        
        for(int i = 0; i < arr.length - 1; i++)
        {
            map.computeIfAbsent(Math.abs(arr[i + 1] - arr[i]), l -> new ArrayList<>()).add(new ArrayList<>(Arrays.asList(arr[i], arr[i + 1])));
        }
        
        return map.get(map.firstKey());
    }
}