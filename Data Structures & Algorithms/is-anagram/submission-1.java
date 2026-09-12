class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();

        HashMap<Character, Integer> index = new HashMap<>();
        for (char c : chars) {
            if (index.containsKey(c)) {
                int value = index.get(c) + 1;
                index.put(c, value);
            } else {
                index.put(c, 1);
            }
        }

        for (char e : chart) {
            if (index.containsKey(e)) {
                int value = index.get(e) - 1;
                index.put(e, value);
            } else {
                return false;
            }
        }

        for (char d : index.keySet()) {
            int value = index.get(d);
            if (value != 0) return false;
        }
        return true;
    }
}
