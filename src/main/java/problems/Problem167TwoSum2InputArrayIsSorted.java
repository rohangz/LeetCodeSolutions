package problems;

public class Problem167TwoSum2InputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int startIndex = 0;
        int endIndex = numbers.length - 1;
        int[] result = new int[]{-1, -1};
        while (startIndex < endIndex) {
            if (numbers[startIndex] + numbers[endIndex] < target) {
                startIndex++;
            } else if (numbers[startIndex] + numbers[endIndex] > target) {
                endIndex--;
            } else {
                result[0] = startIndex + 1;
                result[1] = endIndex + 1;
                break;
            }
        }
        return result;
    }
}
