// You have a list of words and a pattern, and you want to know which words in words matches the pattern.
// A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
// (Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)
// Return a list of the words in words that match the given pattern.
// You may return the answer in any order.


// Iterate each word in the words array, check if current word matches the pattern
// Check pattern match: Use a hashMap<Character in pattern, it's mapped letter>
// Iterate each letter in pattern, if it's not in map, add it with value of the char in cur word
// , however, if that char is already used, break from cur word
// Else, check if the char at cur word matches the char at map? If not, break from cur word
// If we reach the last character of cur word and still matches, add cur word to result list
// Edge Case: If the length of pattern is 1, return each word in words array
// Time: O(n), Space: O(1)

import java.util.*;

class Solution {
    public static void main(String[] args) {
        String [] words = new String[]{"abc","deq","mee","aqq","dkd","ccc"};
        List<String> res = new Solution().findAndReplacePattern(words, "abb");
        for(String s : res) {
            System.out.print(s + " ");
        }
    }
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        if(pattern.length() == 1) {
            return Arrays.asList(words);
        }

        List<String> res = new ArrayList();
        HashMap<Character, Character> map = new HashMap();
        HashSet<Character> letters = new HashSet();
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < pattern.length(); j++) {
                char w = words[i].charAt(j);
                char p = pattern.charAt(j);
                if(!map.containsKey(p)) {
                    // Find more than 1 char matches to the same letter
                    if(letters.contains(w)) {
                        break;
                    }
                    map.put(p, w);
                    letters.add(w);
                }
                else {
                    if(map.get(p) != w) {
                        break;
                    }
                }

                // Reach the end of current word, add to result
                if(j == pattern.length()-1) {
                    res.add(words[i]);
                }
            }
            map.clear();
            letters.clear();
        }
        return res;
    }
}