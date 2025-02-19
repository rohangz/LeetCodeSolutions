package problems;

public class Problem567PermutationInString {
    private int[] setupCharCount(String s, int start, int end) {
        int[] charCount = new int[26];
        for (int i = start; i < end; i++) {
            charCount[s.charAt(i) - 'a']++;
        }
        return charCount;
    }

    private boolean areEqualCharCount(int[] count1, int[] count2) {
        for (int i = 0; i < count1.length; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] charCount1 = setupCharCount(s1, 0, s1.length());
        for (int i = 0; (i + s1.length()) <= s2.length(); i++) {
            if (areEqualCharCount(charCount1, setupCharCount(s2, i, i + s1.length()))) {
                return true;
            }
        }
        return false;
    }
}
