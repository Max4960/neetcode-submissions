class Solution {
    public boolean isValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        boolean changed = true;

        while (changed) {
            changed = false;
            for (int i = 0; i < sb.length() -1; i++) {
                char c1 = sb.charAt(i);
                char c2 = sb.charAt(i+1);
                if ((c1 == '(' && c2 == ')') ||
                     c1 == '{' && c2 == '}' ||
                     c1 == '[' && c2 == ']') {
                    sb.delete(i, i+2); // start index is inclusive, end is exclusive
                    changed = true;
                    break;
                }
            }
        }
        return sb.isEmpty();
    }
}
