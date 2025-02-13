package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem15ThreeSum {

    private List<List<Integer>> getListFrom2Sum(int currentItemIndex, int[] nums, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        int startIndex = currentItemIndex + 1;
        int endIndex = nums.length - 1;
        while (startIndex < endIndex) {
            if (nums[currentItemIndex] + nums[startIndex] + nums[endIndex] < target) {
                startIndex++;
            } else if (nums[currentItemIndex] + nums[startIndex] + nums[endIndex] > target) {
                endIndex--;
            } else {
                ArrayList<Integer> match = new ArrayList<>();
                match.add(nums[currentItemIndex]);
                match.add(nums[startIndex]);
                match.add(nums[endIndex]);
                result.add(match);
                startIndex++;
                while (startIndex < endIndex && nums[startIndex] == nums[startIndex - 1]) {
                    startIndex++;
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            List<List<Integer>> listFrom2Sum = getListFrom2Sum(i, nums, 0);
            if (!listFrom2Sum.isEmpty()) {
                resultList.addAll(listFrom2Sum);
            }
        }
        return resultList;
    }

    /**
     * [-1,0,1,2,-1,-4]
     * [-1, -1, 0, 1, 2, 4]
     */
}
