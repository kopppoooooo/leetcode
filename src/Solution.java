class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
//        // 方法一：暴力 O(mn) O(1)
//        for (int[] row : matrix) {
//            for (int element : row) {
//                if (element == target) {
//                    return true;
//                }
//            }
//        }
//        return false;

//        // 方法二：按行二分查找 O(mlogn) O(1)
//        for (int[] row : matrix) {
//            int index = search(row, target);
//            if (index >= 0) {
//                return true;
//            }
//        }
//        return false;

        // 方法三：Z字形查找（右上角往左、下查找） O(m+n) O(1)
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }
        return false;
    }

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        boolean result = solution.searchMatrix(matrix, 5);

        System.out.println(result);
    }
}