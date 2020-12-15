import java.util.HashMap;
// You are given two strings s and t. You can select any substring of string s and rearrange the characters of the selected substring.
// Determine the minimum length of the substring of s such that string t is a substring of the selected substring.

public class Solution {
    public static void main(String[] args) {
        System.out.print(new Solution().minLengthSubstring("dcbefebce", "fd"));
    }
    // Add any helper functions you may need here
    // Use a HashMap to store the <Character, Frequency> of string t
    // Loop from the start of s, if the current letter of string s is in t, remove it from the map and record start index if not recorded yet
    // If the map is empty, record the end index
    // ** If the map is not empty, that means there is no such substring, return -1
    // Loop from the end of s and do the same
    // Return the min of the 2 distances
    // Time: O(n), Space: O(m); n is the length of s and m is the length of t
    // Edge Case: s.length is smaller than t.length, return -1

    int minLengthSubstring(String s, String t) {
        // Write your code here
        if(s.length() < t.length()) {
            return -1;
        }
        HashMap<Character, Integer> map = new HashMap();
        for(int i = 0; i < t.length(); i++) {
            map.putIfAbsent(t.charAt(i), 0);
            map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
        }

        HashMap<Character, Integer> map2 = new HashMap(map);
        int startIndex = -1;
        int endIndex = -1;
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                if(startIndex == -1) {
                    startIndex = i;
                }
                int freq = map.get(s.charAt(i));
                if(freq == 1) {
                    map.remove(s.charAt(i));
                }
                else {
                    map.put(s.charAt(i), freq - 1);
                }
            }

            if(map.isEmpty()) {
                endIndex = i;
                break;
            }
        }

        if(!map.isEmpty()) {
            return -1;
        }

        int startIndex2 = -1;
        int endIndex2 = -1;
        for(int i = s.length()-1; i >= 0; i--) {
            if(map2.containsKey(s.charAt(i))) {
                if(startIndex2 == -1) {
                    startIndex2 = i;
                }
                int freq = map2.get(s.charAt(i));
                if(freq == 1) {
                    map2.remove(s.charAt(i));
                }
                else {
                    map2.put(s.charAt(i), freq - 1);
                }
            }

            if(map2.isEmpty()) {
                endIndex2 = i;
                break;
            }
        }
        return Math.min(endIndex - startIndex + 1, startIndex2 - endIndex2 + 1);
    }
}
