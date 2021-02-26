// Implement a document scanning function wordCountEngine, which receives a string document and returns a list of all unique words in it and their number of occurrences, sorted by the number of occurrences in a descending order. If two or more words have the same count, they should be sorted according to their order in the original sentence. Assume that all letters are in english alphabet. You function should be case-insensitive, so for instance, the words “Perfect” and “perfect” should be considered the same word.
// The engine should strip out punctuation (even in the middle of a word) and use whitespaces to separate words.

// Analyze the time and space complexities of your solution. Try to optimize for time while keeping a polynomial space complexity.

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String [][] res = new Solution().wordCountEngine("Practice makes perfect. you'll only get Perfect by practice. just practice!");
        for(String [] arr : res) {
            System.out.println(arr[0] + ", " + arr[1]);
        }
    }

    static class Word {
        int index;
        int freq;
        public Word(int index, int freq) {
            this.index = index;
            this.freq = freq;
        }
    }
    String[][] wordCountEngine(String document) {
        // your code goes here
        HashMap<String, Word> map = new HashMap();

        String[] arr = document.toLowerCase().trim().split(" ");
        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < word.length(); j++) {
                if (Character.isAlphabetic(word.charAt(j))) {
                    sb.append(word.charAt(j));
                }
            }
            word = sb.toString();
            if (word.length() > 0) {
                map.putIfAbsent(word, new Word(i, 0));
                map.get(word).freq += 1;
            }
        }
        //int maxCount = 0;
        //for(Map.Entry<String, Integer> entry : map.entrySet()) {
        //System.out.println(entry.getKey() + " " + entry.getValue());
        //}
        String str = document.toLowerCase();
        List<Map.Entry<String, Word>> res = new ArrayList(map.entrySet());
        Collections.sort(res, new Comparator<Map.Entry<String, Word>>() {
            public int compare(Map.Entry<String, Word> e1, Map.Entry<String, Word> e2) {
                if (e1.getValue().freq == e2.getValue().freq) {
                    return e1.getValue().index < e2.getValue().index ? -1 : 1;
                }
                return e1.getValue().freq < e2.getValue().freq ? 1 : -1;
            }
        });

        List<String[]> ans = new ArrayList();
        for (Map.Entry<String, Word> entry : res) {
            String[] a = new String[2];
            a[0] = entry.getKey();
            a[1] = String.valueOf(entry.getValue().freq);
            ans.add(a);
        }

        return ans.toArray(new String[ans.size()][2]);
    }
}
