package problems;

import java.util.Arrays;
import java.util.HashMap;

public class Problem1TwoSum {
    /**
     * Time Complexity -> O(n^2)
     * Space Complexity -> O(1)
     */
    public int[] twoSumBruteForce(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Time Complexity -> O(n lg n)
     * Space Complexity -> O(1)
     */
    public int[] twoSumSorting(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                result[0] = i;
                result[1] = j;
                break;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }

    /**
     * Time Complexity -> O(n)
     * Space Complexity -> O(n)
     */
    public int[] twoSumHashing(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (indexMap.containsKey(diff)) {
                result[0] = i;
                result[1] = indexMap.get(diff);
                break;
            } else {
                indexMap.put(nums[i], i);
            }
        }
        return result;
    }
}
