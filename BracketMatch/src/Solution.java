// A string of brackets is considered correctly matched if every opening bracket in the string can be paired up with a later closing bracket, and vice versa. For instance, “(())()” is correctly matched, whereas “)(“ and “((” aren’t. For instance, “((” could become correctly matched by adding two closing brackets at the end, so you’d return 2.

// Given a string that consists of brackets, write a function bracketMatch that takes a bracket string as an input and returns the minimum number of brackets you’d need to add to the input in order to make it correctly matched.

// Explain the correctness of your code, and analyze its time and space complexities.

public class Solution {
    public static void main(String[] args) {
        System.out.print(new Solution().bracketMatch("(((((((())"));
    }
    // Use 2 variables to store the number of unused open and close brackets
    // Iterate the input string, if the current one is closing and open brackets > 0. We can make a pair, reduce open bracket by 1. Else, add close bracket by 1
    // Else, just increase the open bracket by 1
    // Time: O(n), Space: O(1)
    public int bracketMatch(String text) {
        // your code goes here
        int openB = 0;
        int closeB = 0;
        for(int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == ')') {
                if(openB > 0) {
                    openB--;
                }
                else {
                    closeB++;
                }
            }
            else {
                openB++;
            }
        }
        return openB + closeB;
    }
}
