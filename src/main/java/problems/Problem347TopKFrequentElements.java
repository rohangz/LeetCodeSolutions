package problems;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem347TopKFrequentElements {
    /**
     * Time Complexity -> O(n lg k)
     * Space Complexity -> O(n)
     */
    public int[] topKFrequentHashMap(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (countMap.get(num) == null) {
                countMap.put(num, 1);
            } else {
                countMap.compute(num, (key, count) -> count + 1);
            }
        }
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> countMap.get(a) - countMap.get(b));
        for (int num : countMap.keySet()) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[] resultArray = new int[k];
        for (int i = 0; i < k; i++) {
            resultArray[i] = heap.poll();
        }
        return resultArray;
    }

    /**
     * Time Complexity -> ?
     * Space Complexity -> ?
     */
    public int[] topKFrequentGoldenKeyApproach(int[] nums, int k) throws Exception {
        throw new Exception("Not yet implemented");
    }
}
