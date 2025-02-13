package problems;

public class Problem238ProductOfAnArrayExceptSelf {

    /**
     * Time Complexity -> O(n)
     * Space Complexity -> O(1)
     */
    private void setupPrefix(int[] nums, int[] resultArray) {
        int prefixProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                resultArray[i] = prefixProduct;
            } else {
                prefixProduct = prefixProduct * nums[i - 1];
                resultArray[i] = prefixProduct;
            }
        }
    }

    private void setupPostFix(int[] nums, int[] resultArray) {
        int postFixProduct = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            postFixProduct = postFixProduct * nums[i + 1];
            resultArray[i] = resultArray[i] * postFixProduct;
        }
    }


    public int[] productExceptSelfPreFixPostFix(int[] nums) {
        int[] resultArr = new int[nums.length];
        setupPrefix(nums, resultArr);
        setupPostFix(nums, resultArr);
        return resultArr;
    }
}
