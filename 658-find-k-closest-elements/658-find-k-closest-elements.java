class Solution {
public List<Integer> findClosestElements(int[] arr, int k, int x) {
	var i = Arrays.binarySearch(arr, x);
	if (i < 0)
		i = ~i;
		
	var heap = new PriorityQueue<>(Comparator.comparing((Integer n) -> -Math.abs(x - n))
											 .thenComparing((Integer n) -> -n));

	for (int j = i - k, high = Math.min(i + k, arr.length - 1); j <= high; j++)
		if (j >= 0) {
			heap.add(arr[j]);
			if (heap.size() > k)
				heap.poll();
		}

	var closest = new ArrayList<>(heap);
	closest.sort(Comparator.naturalOrder());
	return closest;
}
}