package problems;

import java.util.ArrayList;
import java.util.List;

public class Problem271EncodeAndDecodeStrings {

    private String encodeLength(String s) {
        int stringLength = s.length();
        StringBuilder sb = new StringBuilder();
        if (stringLength < 10) {
            sb.append("00");
        } else if (stringLength < 100) {
            sb.append("0");
        }
        sb.append(stringLength);
        return sb.toString();
    }

    public String encode(List<String> strs) {
        StringBuilder encodedStringBuilder = new StringBuilder();
        for (String str : strs) {
            encodedStringBuilder.append(encodeLength(str));
            encodedStringBuilder.append(str);
        }
        return encodedStringBuilder.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        ArrayList<String> decodedList = new ArrayList<>();
        int i = 0;
        int lengthOfString = -1;
        while (i < s.length()) {
            lengthOfString = Integer.parseInt(s.substring(i, i + 3));
            i += 3;
            if (lengthOfString != 0) {
                decodedList.add(s.substring(i, i + lengthOfString));
            } else {
                decodedList.add("");
            }
            i += lengthOfString;
        }
        return decodedList;
    }
}
