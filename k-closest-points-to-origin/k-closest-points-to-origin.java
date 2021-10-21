class Solution {
    public int[][] kClosest(int[][] points, int K) {
        //better solution
        //create minHeap
        //loop through from 1 to k poll onto output array
        //return array
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(K, new Comparator<int[]>() {
            public int compare(int[] a, int[] b)
            {
                return (((a[0]) * (a[0]) + (a[1] * a[1])) - ((b[0]) * (b[0]) + (b[1] * b[1])));
            }
        });
        
        for(int[] point : points)
        {
            minHeap.add(point);
        }
            
        int[][] output = new int[K][2];
        
        for(int i = 0; i < K; i++)
        {
            output[i] = minHeap.poll();
        }
            
        
        return output;
        
        
        /*
        //base check if points.length = k return points
        //create treemap double is key and array is value
        //loop through points and calculate euclidean distance and map it to the array
        //loop through the treemap from to k and add to ouput
        //return output
        
        if(points.length == K) return points;
        
        TreeMap<Double, int[]> map = new TreeMap<>();
        
        for(int[] point : points)
        {
            double distance = Math.sqrt((point[0] * point[0]) + (point[1] * point[1]));
            if(map.containsKey(distance))
            {
                map.put(distance + 0.00001, point);
            }
            else
            {
                map.put(distance, point);
            }
        }
        
        int[][] output = new int[K][2];
        int index = 0;
        for(double pointDistance : map.keySet())
        {
            if(K > 0)
            {
                output[index++] = map.get(pointDistance);
                K--;
            }
            else
            {
                break;
            }
        }
        
        return output;
    }
    */
}
}