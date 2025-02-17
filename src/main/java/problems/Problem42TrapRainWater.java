package problems;

public class Problem42TrapRainWater {
    /**
     * Time Complexity O(n)
     * Space Complexity O(n)
     */
    private void populateMaxLeftArray(int[] maxFromLeft, int[] height) {
        maxFromLeft[0] = 0;
        for (int i = 1; i < height.length; i++) {
            maxFromLeft[i] = Math.max(maxFromLeft[i - 1], height[i - 1]);
        }
    }

    private void populateMaxRightArray(int[] maxFromRight, int[] height) {
        maxFromRight[maxFromRight.length - 1] = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            maxFromRight[i] = Math.max(maxFromRight[i + 1], height[i + 1]);
        }
    }

    private int calculateTrappedWater(int[] maxFromLeft, int[] maxFromRight, int[] height) {
        int trappedWater = 0;
        for (int i = 1; i < height.length - 1; i++) {
            if (maxFromLeft[i] != 0 && maxFromRight[i] != 0) {
                int trapped = Math.min(maxFromLeft[i], maxFromRight[i]) - height[i];
                if (trapped > 0) {
                    trappedWater += trapped;
                }
            }
        }
        return trappedWater;
    }

    public int trap(int[] height) {
        int[] maxFromLeft = new int[height.length];
        int[] maxFromRight = new int[height.length];
        populateMaxLeftArray(maxFromLeft, height);
        populateMaxRightArray(maxFromRight, height);
        return calculateTrappedWater(maxFromLeft, maxFromRight, height);
    }

    /**
     * Time Complexity O(n)
     * Space Complexity O(1)
     */
    public int trapOptimal(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int maxLeft = height[0];
        int maxRight = height[height.length - 1];
        int start = 0, end = height.length - 1;
        int trappedWater = 0;
        while (start < end) {
            if (maxLeft < maxRight) {
                start++;
                maxLeft = Math.max(height[start], maxLeft);
                trappedWater += (maxLeft - height[start]);

            } else {
                end--;
                maxRight = Math.max(height[end], maxRight);
                trappedWater += (maxRight - height[end]);


            }
        }
        return trappedWater;
    }
}
