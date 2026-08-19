class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> seen = new HashSet<>();
        int left = 0;
        int right = 0;
        int max = 0;

        while (right < s.length()) {
            if (!seen.contains(s.charAt(right))) {
                seen.add(s.charAt(right));
                right++;
                if (right - left > max) {
                    max = right - left;
                }
            } else {
                seen.remove(s.charAt(left));
                left++;
                
            }
        }
        return max;
    }
}
