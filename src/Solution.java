import java.util.Arrays;

class Solution {
    public void rotate(int[] nums, int k) {
//        int n = nums.length;
//        int[] newArr = new int[n];
//        for (int i = 0; i < n; ++i) {
//            newArr[(i + k) % n] = nums[i];
//        }
//        System.arraycopy(newArr, 0, nums, 0, n);

        // 法2: 三次反转 O(n)/O(1)
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);  // 整体反转
        reverse(nums, 0, k - 1);  // 反转前k个
        reverse(nums, k, n - 1);  // 反转剩余部分
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        solution.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}