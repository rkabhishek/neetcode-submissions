class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> scores = new Stack<>();
        for (String op : operations) {
            if (op.equals("D")) {
                int val = scores.peek();
                scores.push(2 * val);
            } else if (op.equals("C")) {
                scores.pop();
            } else if (op.equals("+")) {
                int prev1 = scores.pop();
                int prev2 = scores.pop();
                scores.push(prev2);
                scores.push(prev1);
                scores.push(prev1 + prev2);
            } else {
               scores.push(Integer.parseInt(op));
            }
        }

        int sum = 0;
        for (int i : scores) {
            sum += i;
        }

        return sum;
           
    }
}