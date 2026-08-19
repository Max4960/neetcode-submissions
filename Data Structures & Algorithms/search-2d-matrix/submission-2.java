class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int bottom = 0;
        int top = matrix.length-1;
        int row = -1;
        while (bottom <= top) {
            int mid = bottom + (top - bottom) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                row = mid;
                bottom = mid + 1;
            } else {top = mid - 1;}
        }
        if (row == -1) {return false;}
        int left = 0;
        int right = matrix[row].length - 1;
        while (left <= right) {
            int m = left + (right - left) / 2;
            if (matrix[row][m] == target) {
                return true;
            } else if (matrix[row][m] < target) {
                left = m + 1;
            } else {
                right = m - 1;
            }
        }

        return false;
    }
}
