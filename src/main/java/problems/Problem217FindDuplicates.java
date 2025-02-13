package problems;

import java.util.Arrays;
import java.util.HashSet;

public class Problem217FindDuplicates {


    /**
     * Time Complexity -> O(n^2)
     * Space Complexity -> O(1)
     */
    public boolean doesDuplicateExistBruteForce(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Time Complexity -> O(n lg n)
     * Space Complexity -> O(1)
     */
    public boolean doesDuplicateExistsSorting(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums [i+1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Time Complexity -> O(n)
     * Space Complexity -> O(n)
     */
    public boolean doesDuplicateExistsHashSet(int []nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int num : nums) {
            if (hashSet.contains(num)) {
                return true;
            } else {
                hashSet.add(num);
            }
        }
        return false;
    }
}
