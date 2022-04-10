class Solution {
    public int calPoints(String[] ops) {
        //stack
        Stack<Integer> s = new Stack<>();
        int total = 0, temp;
        for(String op : ops) {           //  for each loop for string array
            if(op.equals("C")) {
                total -= s.pop();
            }
            else if(op.equals("D")) {
                temp = 2*s.peek();
                s.push(temp);
                total += temp;
            }
            else if(op.equals("+")) {
                temp = s.pop();
                int sum = temp + s.peek();
                s.push(temp);
                s.push(sum);
                total += sum;
            }
            else {
                temp = Integer.parseInt(op);
                s.push(temp);
                total += temp;
            }
        }
        return total;
    }
}