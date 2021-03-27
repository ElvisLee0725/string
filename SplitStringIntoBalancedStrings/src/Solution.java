// Balanced strings are those that have an equal quantity of 'L' and 'R' characters.
// Given a balanced string s, split it in the maximum amount of balanced strings.
// Return the maximum amount of split balanced strings.

// Time: O(n), Space: O(1)
class Solution {
    public static void main(String[] args) {
        System.out.print(new Solution().balancedStringSplit("RLLLLRRRLR"));
    }
    public int balancedStringSplit(String s) {
        int countL = 0;
        int countR = 0;
        int counter = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'L') {
                countL++;
            }
            else {
                countR++;
            }

            if(countL == countR) {
                counter++;
                countL = 0;
                countR = 0;
            }
        }
        return counter;
    }
}
