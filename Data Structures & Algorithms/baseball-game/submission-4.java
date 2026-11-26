class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> scores = new Stack<>();
        int sum = 0;
        for (String op : operations) {
            if (op.equals("D")) {
                scores.push(2 * scores.peek());
                sum += scores.peek();
            } else if (op.equals("C")) {
                sum -= scores.pop();
            } else if (op.equals("+")) {
                int prev1 = scores.pop();
                int prev2 = scores.pop();
                scores.push(prev2);
                scores.push(prev1);
                scores.push(prev1 + prev2);
                sum += scores.peek();
            } else {
                scores.push(Integer.parseInt(op));
                sum += scores.peek();
            }
        }
        return sum;
    }
}