import java.util.*;

public class Ejercicio2 {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        
        int wordLength = words[0].length();
        int totalWords = words.length;
        int totalLength = wordLength * totalWords;
        
        if (s.length() < totalLength) {
            return result;
        }
        
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        for (int i = 0; i <= s.length() - totalLength; i++) {
            String current = s.substring(i, i + totalLength);
            Map<String, Integer> tempMap = new HashMap<>();
            
            for (int j = 0; j < totalLength; j += wordLength) {
                String word = current.substring(j, j + wordLength);
                tempMap.put(word, tempMap.getOrDefault(word, 0) + 1);
            }
            
            if (tempMap.equals(wordCount)) {
                result.add(i);
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        List<Integer> indices = findSubstring(s, words);
        System.out.println("Índices de inicio: " + indices);
    }
}