// Given an array of strings words, find the longest string in words such that every prefix of it is also in words.
//
// For example, let words = ["a", "app", "ap"]. The string "app" has prefixes "ap" and "a", all of which are in words.
// Return the string described above. If there is more than one string with the same length, return the lexicographically smallest one, and if no string exists, return "".

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

// Trie:
// Build a trie with all words from the input. Use TreeMap to make sure when traverse, it is starting from a to z.
// Traverse the trie tree and update the longest word if current string is a word and its length is greatest.
// If none of current trie node's child is a word, skip all its children
// Return the longest word at the end
// Time: O(MN) M is the length of word, N is the length of input words. Space: O(MN)
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().longestWord2(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
    }
    class TrieNode {
        TreeMap<Character, TrieNode> children;
        boolean endOfWord;
        public TrieNode() {
            this.children = new TreeMap();
            this.endOfWord = false;
        }
    }

    TrieNode root;
    int max;
    String res;
    public String longestWord(String[] words) {
        root = new TrieNode();
        max = 0;
        res = "";
        for(String word : words) {
            addTrie(word);
        }

        StringBuilder sb = new StringBuilder();
        dfs(root, sb);

        return res;
    }

    private void dfs(TrieNode node, StringBuilder sb) {
        for(Character ch : node.children.keySet()) {
            sb.append(ch);
            if(node.children.get(ch).endOfWord) {
                if(sb.length() > max) {
                    max = sb.length();
                    res = sb.toString();
                }

                dfs(node.children.get(ch), sb);
            }
            sb.deleteCharAt(sb.length()-1);
        }
    }

    private void addTrie(String s) {
        TrieNode node = root;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode());
            }
            node = node.children.get(ch);
        }
        node.endOfWord = true;
    }

    // Trie:
    // Use an array of length 26 to represent each letter
    // Sort the input array by the length of string. If length equal sort by alphabetic
    // For each word, try to add each letter to trie. If there is any char not end of word, that means there is no prefix, we can return false
    // Only if each char is endOfWord, we successfully build a word, return true.
    class TrieNode2 {
        TrieNode2 [] children;
        boolean endOfWord;
        public TrieNode2() {
            this.children = new TrieNode2[26];
            this.endOfWord = false;
        }
    }
    TrieNode2 root2;
    public String longestWord2(String[] words) {
        root2 = new TrieNode2();
        root2.endOfWord = true;  // Set root to true for addTrie to work
        res = "";

        Arrays.sort(words, new Comparator<String>(){
            public int compare(String s1, String s2) {
                if(s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                }
                return s1.length() - s2.length();
            }
        });

        for(String word : words) {
            if(addTrie2(word) && word.length() > res.length()) {
                res = word;
            }
        }

        return res;
    }

    private boolean addTrie2(String s) {
        TrieNode2 node = root2;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // If there is any character that's not endOfWord, it's not a prefix
            if(!node.endOfWord) {
                return false;
            }
            if(node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode2();
            }
            node = node.children[ch - 'a'];
        }
        node.endOfWord = true;
        return true;
    }
}
