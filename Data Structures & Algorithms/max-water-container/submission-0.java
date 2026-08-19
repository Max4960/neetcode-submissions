class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int max = 0;

        while (left < right) {
            int area = (right - left) * Math.min(heights[left], heights[right]);
            if (area > max) {
                max = area;
            } else if (heights[left] > heights[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }
}
