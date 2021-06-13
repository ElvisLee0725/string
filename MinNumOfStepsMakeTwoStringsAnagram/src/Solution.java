// Given two equal-size strings s and t. In one step you can choose any character of t and replace it with another character.
//
// Return the minimum number of steps to make t an anagram of s.
//
// An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.

// Use an array of length 26 to store the number of each letter in string s. Ex. arr[0] = 2 means s has 2 a
// Iterating the string t. If current char is in arr with frequency greater than 0, reduce by 1
// Else, counter incresase by 1 since we need to change it to make anagram
// Return the counter
// Time: O(m+n), Space: O(1)
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minSteps("leetcode", "practice"));
    }
    public int minSteps(String s, String t) {
        int [] arr = new int[26];
        for(int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        int count = 0;
        for(int i = 0; i < t.length(); i++) {
            char cur = t.charAt(i);
            if(arr[cur - 'a'] > 0) {
                arr[cur - 'a']--;
            }
            else {
                count++;
            }
        }
        return count;
    }
}