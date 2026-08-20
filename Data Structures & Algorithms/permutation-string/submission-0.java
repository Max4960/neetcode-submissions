class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] temp = s1.toCharArray();
        Arrays.sort(temp);
        s1 = new String(temp);

        int size = s1.length();
        for (int i = 0; i < s2.length() - size; i++) {
            String sub = s2.substring(i, i+size);
            char[] subChars = sub.toCharArray();
            Arrays.sort(subChars);

            if (s1.equals(new String(subChars))) {
                return true;
            }
        }
        return false;
    }
}
