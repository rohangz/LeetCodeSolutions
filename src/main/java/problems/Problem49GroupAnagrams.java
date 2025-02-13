package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem49GroupAnagrams {

    private String createAnagramString(String s) {
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (charCount[i] != 0) {
                sb.append(i + 'a');
                sb.append(charCount[i]);
            }
        }
        return sb.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length < 1) {
            return new ArrayList<>();
        }
        HashMap<String, ArrayList<String>> resultMap = new HashMap<>();
        for (String str : strs) {
            String anagramString = createAnagramString(str);
            if (resultMap.get(anagramString) == null) {
                ArrayList<String> anagrams = new ArrayList<>();
                anagrams.add(str);
                resultMap.put(anagramString, anagrams);
            } else {
                resultMap.get(anagramString).add(str);
            }
        }
        ArrayList<List<String>> anagramResult = new ArrayList<>();
        for (String key: resultMap.keySet()) {
            ArrayList<String> anagramForKey = resultMap.get(key);
            anagramResult.add(anagramForKey);
        }
        return anagramResult;
    }
}
