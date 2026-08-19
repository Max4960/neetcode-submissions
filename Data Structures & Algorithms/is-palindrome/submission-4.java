class Solution {
    public boolean isPalindrome(String s) {
        String an = s.replaceAll("[^a-zA-Z0-9]", "");
        an = an.toLowerCase();
        int i = 0;
        int j = an.length()-1;
        char[] letters = an.toCharArray();
        while (i<j) {
            if (letters[i] != letters[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
