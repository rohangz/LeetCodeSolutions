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

    private int getMatchCount(int[] count1, int[] count2) {
        int matchCount = 0;
        for (int i = 0; i < count1.length; i++) {
            if (count1[i] == count2[i]) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean checkInclusionOptimal(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] charCount1 = setupCharCount(s1, 0, s1.length());
        int[] charCount2 = setupCharCount(s2, 0, s1.length());
        int matchCount = getMatchCount(charCount1, charCount2);
        int i = 0, j = s1.length();
        while (j < s2.length()) {
            if (matchCount == 26) {
                return true;
            }
            charCount2[s2.charAt(j) - 'a']++;
            if (charCount1[s2.charAt(j) - 'a'] == charCount2[s2.charAt(j) - 'a']) {
                matchCount++;
            } else if ((charCount1[s2.charAt(j) - 'a'] + 1) == charCount2[s2.charAt(j) - 'a']) {
                matchCount--;
            }
            charCount2[s2.charAt(i) - 'a']--;
            if (charCount1[s2.charAt(i) - 'a'] == charCount2[s2.charAt(i) - 'a']) {
                matchCount++;
            } else if ((charCount1[s2.charAt(i) - 'a'] - 1) == charCount2[s2.charAt(i) - 'a']) {
                matchCount--;
            }
            i++;
            j++;
        }
        return matchCount == 26;
    }
}
