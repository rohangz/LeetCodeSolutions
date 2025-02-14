package problems;

public class Problem11ContainerWithMostWater {

    /**
     * Time Complexity O(n^2)
     * Space Complexity O(1)
     */
    public int maxAreaBruteForce(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return maxArea;
    }

    /**
     * Time Complexity O(n)
     * Space Complexity O(1)
     */
    public int maxAreaOptimal(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int maxArea = 0;
        int start = 0, end = height.length - 1;
        while (start < end) {
            maxArea = Math.max(maxArea, (Math.min(height[start], height[end]) * (end - start)));
            if (height[start] <= height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return maxArea;
    }
}
