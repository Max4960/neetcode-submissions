class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int bottom = 0;
        int top = matrix.length-1;
        while (bottom <= top) {
            int mid = bottom + (top - bottom) / 2;
            if (matrix[mid][0] <= target) {
                int left = 0;
                int right = matrix[mid].length - 1;

                while (left <= right) {
                    int m = left + (right - left) / 2;
                    if (matrix[mid][m] == target) {
                        return true;
                    } else if (matrix[mid][m] < target) {
                        left = m + 1;
                    } else {
                        right = m - 1;
                    }
                }
                return false;
            } else if (matrix[mid][0] > target) {
                //  search columns before mid
                top = mid - 1;
            } else {
                bottom = mid + 1;
                // search columns up to and including mid
            }
        }
        return false;
    }
}
