class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        for (int i = 0; i < strs[0].length(); i++) {
            for (String str : strs) {
                if (str.equals("")) {
                    return "";
                }
                if (i >= str.length() || str.charAt(i) != strs[0].charAt(i)) {
                    return prefix;
                }
            }
            prefix += strs[0].charAt(i);
        }
        return prefix;
    }
}