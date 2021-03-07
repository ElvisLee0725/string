// Given an encoded string, return its decoded string.

// The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

// You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

// Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

// Key point: When the input s has nested [[]], we need to decode the inner [] first, then the outer
// Use Recursion:
// When getting digits, get the whole number and call recursion
// Inside the recurion, check conditions
// If cur char is letter, concatenate it
// Else if is a digit, get the whole digit to pass down and call recursion
// Else if it's a ']', return the repeat time * substring
// Return the whole new string
// Time: O(n), Space: O(1)

class Solution {
    public static void main(String[] args) {
        System.out.print(new Solution().decodeString("3[a2[c]]"));
    }
    int index;
    public String decodeString(String s) {
        index = 0;
        StringBuilder sb = new StringBuilder();
        while(index < s.length()) {
            if(Character.isDigit(s.charAt(index))) {
                int x = 0;
                while(Character.isDigit(s.charAt(index))) {
                    x = x * 10 + s.charAt(index) - '0';
                    index++;
                }
                index++;
                sb.append(helper(s, x));
            }
            else {
                sb.append(s.charAt(index));
                index++;
            }
        }
        return sb.toString();
    }

    public String helper(String s, int repeat) {
        StringBuilder sb = new StringBuilder();
        while(index < s.length()) {
            if(Character.isDigit(s.charAt(index))) {
                int x = 0;
                while(Character.isDigit(s.charAt(index))) {
                    x = x * 10 + s.charAt(index) - '0';
                    index++;
                }
                index++;
                sb.append(helper(s, x));
            }
            else if(s.charAt(index) == ']') {
                String temp = sb.toString();
                for(int i = 0; i < repeat-1; i++) {
                    sb.append(temp);
                }
                index++;
                return sb.toString();
            }
            else {
                sb.append(s.charAt(index));
                index++;
            }
        }
        return sb.toString();
    }
}
