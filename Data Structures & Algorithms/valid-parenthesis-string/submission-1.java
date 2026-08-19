class Solution {
    public static boolean checkValidString(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();
        int right = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                left.push(i);
            } else if (chars[i] == '*') {
                star.push(i);
            } else {
                if (!left.isEmpty()) {
                    left.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                } else {
                    return false; // found unmatched ')'
                }
            }
        }
        while (!left.isEmpty() && !star.isEmpty()) {
            int leftindex = left.pop();
            int starindex = star.pop();
            // spare star before (
            if (starindex < leftindex) {
                return false;
            }
        }
        // more ( then * remaining
        return left.isEmpty();
    }
}
