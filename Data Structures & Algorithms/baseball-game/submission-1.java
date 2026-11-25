class Solution {
    public int calPoints(String[] operations) {
        int[] scores = new int[1000];
        int index = -1;

        for (String op : operations) {
            if (op.equals("D")) {
                int val = 2 * scores[index];
                scores[++index] = val;
            } else if (op.equals("C")) {
                index--;
            } else if (op.equals("+")) {
                int val = scores[index] + scores[index - 1];
                scores[++index] = val;
            } else {
                scores[++index] = Integer.parseInt(op);
            }
        }

        int sum = 0;
        for (int i = 0; i <= index; i++) {
            sum += scores[i];
        }

        return sum;
    }
}