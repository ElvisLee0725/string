// Given a string s. You should re-order the string using the following algorithm:
//
// Pick the smallest character from s and append it to the result.
// Pick the smallest character from s which is greater than the last appended character to the result and append it.
// Repeat step 2 until you cannot pick more characters.
// Pick the largest character from s and append it to the result.
// Pick the largest character from s which is smaller than the last appended character to the result and append it.
// Repeat step 5 until you cannot pick more characters.
// Repeat the steps from 1 to 6 until you pick all characters from s.
// In each step, If the smallest or the largest character appears more than once you can choose any occurrence and append it to the result.

// Return the result string after sorting s with this algorithm.

// Use an array of length 26 to record the frequency of each letter in s, arr[0] = 1 represents 'a' has frequency of 1
// While the stringbuilder's length is not equal to the original string, keep iterating from left to right, right to left and append each letter with value greater than 0 and reduce frequency
// Return the final string at the end
// Time: O(n), Space: O(n)
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().sortString("aaaabbbbcccc"));
    }
    public String sortString(String s) {
        int [] arr = new int[26];
        for(int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        while(sb.length() != s.length()) {
            for(int i = 0; i < 26; i++) {
                if(arr[i] > 0) {
                    sb.append((char) ('a' + i));
                    arr[i]--;
                }
            }

            for(int i = 25; i >= 0; i--) {
                if(arr[i] > 0) {
                    sb.append((char) ('a' + i));
                    arr[i]--;
                }
            }
        }
        return sb.toString();
    }
}
