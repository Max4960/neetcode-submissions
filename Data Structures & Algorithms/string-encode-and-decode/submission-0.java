class Solution {

    public String encode(List<String> strs) {
        // encode like #4neet#4code#4love#3you
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            int num = str.length();
            sb.append(str.length()).append("#").append(str);
            //System.out.println(sb);
        }
        return sb.toString();

    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j));
            //System.out.println(length);
            res.add(str.substring(j+1, j+1+length));
            i = j + 1 + length;
        }
        return res;
    }
}
