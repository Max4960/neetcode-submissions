class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> seen = new HashSet<>();
        char[] chars = s.toCharArray();
        int left = 0;
        int max = 0;

        for (int right = 0; right < chars.length; right++) {
            while (seen.contains(chars[right])) {
                seen.remove(chars[left]);
                left++;
            }
            seen.add(chars[right]);
            if (right - left + 1 > max) {
                max = right - left + 1;
            }
        }
        return max;
    }
}
