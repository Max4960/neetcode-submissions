class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length-1;

        int l = 0;
        int r = matrix[0].length-1;

        while (top <= bottom) {
            int mid = (top + bottom) / 2;
            if (matrix[mid][0] == target) {
                return true;
            }
            if (matrix[mid][0] > target) {
                bottom = mid-1;
            } else {
                top = mid+1;
            }
        }

        while (l <= r) {
            int mid = (l + r) / 2;
            if (matrix[bottom][mid] == target) {
                return true;
            }
            if (matrix[bottom][mid] > target) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return false;
    }
}
