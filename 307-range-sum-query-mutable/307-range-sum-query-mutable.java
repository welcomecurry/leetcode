class NumArray {

private int[] tree;
private int size;

//segment Tree
public NumArray(int[] nums) {
    tree = new int[nums.length * 4];
    size = nums.length;
    init(nums, 1, 0, size - 1);
}

public void update(int index, int val) {
    updateMake(index, val, 1, 0, size - 1);
}

public int sumRange(int left, int right) {
    return sum(left, right, 1, 0, size - 1);
}

public int init(int[] arr, int node, int nodeLeft, int nodeRight) {
    
    if(nodeLeft == nodeRight) return tree[node] = arr[nodeLeft];
    
    int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
    
    int leftVal = init(arr, node * 2, nodeLeft, mid);
    int rightVal = init(arr, node * 2 + 1, mid + 1, nodeRight);
    return tree[node] = merge(leftVal, rightVal);
}

public int merge(int left, int right) {
    return left + right;
}

public int sum(int left, int right, int node, int nodeLeft, int nodeRight) {
    if(right < nodeLeft || nodeRight < left) return 0;
    if(left <= nodeLeft && nodeRight <= right) return tree[node];
    
    int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
    return merge(sum(left, right, node * 2, nodeLeft, mid), sum(left, right, node * 2 + 1, mid + 1, nodeRight));
}

public int updateMake(int index, int val, int node, int nodeLeft, int nodeRight) {
    if(index < nodeLeft || nodeRight < index) return tree[node];
    if(nodeLeft == nodeRight) return tree[node] = val;
    
    int mid = nodeLeft + (nodeRight - nodeLeft)/2;
    int leftVal = updateMake(index, val, node * 2, nodeLeft, mid);
    int rightVal = updateMake(index, val, node * 2 + 1, mid + 1, nodeRight);
    
    return tree[node] = merge(leftVal, rightVal);
}
}

