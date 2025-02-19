package problems;

import java.util.Arrays;

public class Problem424LongestRepeatingCharacterReplacement {
    private int maxCharCount(int[] charCount) {
        int maxCount = charCount[0];
        for (int count : charCount) {
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    public int characterReplacement(String s, int k) {
        int[] charCount = new int[26];
        Arrays.fill(charCount, 0);
        int start = 0;
        int maxChars = 0;
        int maxFrequency = 0;
        for (int end = 0; end < s.length(); end++) {
            charCount[s.charAt(end) - 'A']++;
            maxFrequency = Math.max(maxFrequency, charCount[s.charAt(end) - 'A']);
            while ((end - start + 1) - maxFrequency > k) {
                charCount[s.charAt(start) - 'A']--;
                start++;
            }
            maxChars = Math.max(maxChars, end - start + 1);
        }
        return maxChars;
    }
}
