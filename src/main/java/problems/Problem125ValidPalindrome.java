package problems;

public class Problem125ValidPalindrome {
    private boolean isAlphaNumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '1') && (c <= '9');
    }

    public boolean isPalindrome(String s) {
        int startIndex = 0, endIndex = s.length() - 1;
        while (startIndex <= endIndex) {
            while (startIndex <= endIndex && !isAlphaNumeric(s.charAt(startIndex))) {
                startIndex++;
            }
            while (startIndex <= endIndex && !isAlphaNumeric(s.charAt(endIndex))) {
                endIndex--;
            }
            if (startIndex <= endIndex) {
                if (Character.toLowerCase(s.charAt(startIndex)) != Character.toLowerCase(s.charAt(endIndex))) {
                    return false;
                } else {
                    startIndex++;
                    endIndex--;
                }
            }
        }
        return true;
    }
}
