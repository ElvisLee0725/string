// Given a string s formed by digits ('0' - '9') and '#' . We want to map s to English lowercase characters as follows:
//
// Characters ('a' to 'i') are represented by ('1' to '9') respectively.
// Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
// Return the string formed after mapping.
// It's guaranteed that a unique mapping will always exist.

// 2 kinds of characters: one with # at the end and the other doesn't
// Iterating the input string s. Check if i + 2 is within range and it's a '#'? If so, add new char and i += 3
// Else, add new char and i += 1
// Return the final string
// Time: O(n), Space: O(n)
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().freqAlphabets("10#11#12"));
    }
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < s.length()) {
            if(i + 2 < s.length() && s.charAt(i+2) == '#') {
                sb.append((char) (96 + Integer.valueOf(s.substring(i, i+2))));
                i += 3;
            }
            else {
                sb.append((char) (96 + (s.charAt(i) - '0')));
                i += 1;
            }
        }
        return sb.toString();
    }
}
