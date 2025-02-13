package problems;

import java.util.HashSet;
import java.util.Set;

public class Problem128LongestCommonSequence {

    private int getSequenceLengthFromNumber(Set<Integer> numberSet, int startNumber) {
        int length = 0;
        while (numberSet.contains(startNumber + 1)) {
            length++;
            startNumber++;
        }
        return length + 1;
    }

    public int longestConsecutive(int[] nums) {
        int longestCommonSequence = 0;
        HashSet<Integer> numberSet = new HashSet<>();
        for (int num : nums) {
            numberSet.add(num);
        }
        for (int num : numberSet) {
            if (!numberSet.contains(num - 1)) {
                int sequenceLength = getSequenceLengthFromNumber(numberSet, num);
                longestCommonSequence = (longestCommonSequence < sequenceLength) ? sequenceLength : longestCommonSequence;
            }
        }
        return longestCommonSequence;
    }
}
