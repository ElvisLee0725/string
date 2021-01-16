// Given a string with alpha-numeric characters and parentheses, return a string with balanced parentheses by removing the fewest characters possible. You cannot add anything to the string.

// "()" -> "()"
// "a(b)c)" -> "a(b)c"
// ")(" -> ""
// "((a(((" -> "a"
// "(()()(" -> "()()"
// ")(())(" -> "(())"
// ")())(()()(" -> "()()()"

// Alternate correct result
// "(())())" -> "(()())" or "(())()"


public class Solution {
    public static void main(String[] args) {
        System.out.print(new Solution().validParenthesesRecursion("(((((((abcd)))))))"));
    }

    // Recursion:
    // Iterate the input string from index 0 (Record the cur index with global index variable)
    // Case 1: '(', keep diving deep to get it's valid closing pair ')', record everything along the way
    // except the '(' since we can only keep 1 pair.
    // If the return string has length greater than 1, add it to result
    // Case 2: Alpha numeric, Add to result string and move index
    // Case 3: Closing '(' without a open '(', just keep moving index since one ')' won't form a pair

    // In recursion: Each time starts with empty string '' and move index by 1 since we get here at '('
    // Case '(': Call recursion
    // Case ')': Find a pair, return everything including a starting '(' and closing ')'
    // Case other: Add the current character

    int index = 0;
    public String validParenthesesRecursion(String s) {
        String res = "";
        while(index < s.length()) {
            if(s.charAt(index) == '(') {
                String temp = findPair(s);
                if(temp.length() > 0) {
                    res += temp;
                }
            }
            else if(s.charAt(index) != ')') {
                res += s.charAt(index);
                index++;
            }
            else {
                index++;
            }
        }

        return res;
    }

    public String findPair(String s) {
        index++;
        String output = "";
        while(index < s.length()) {
            if(s.charAt(index) == '(') {
                output += findPair(s);
                index++;
            }
            else if(s.charAt(index) == ')') {
                return "(" + output + ")";
            }
            else {
                output += s.charAt(index);
                index++;
            }
        }
        return output;
    }

//    public String validParentheses(String s) {
//        if(s == null || s.length() == 0) {
//            return "";
//        }
//
//        int numOpenP = 0;
//        StringBuilder sb1 = new StringBuilder();
//        for(int i = 0; i < s.length(); i++) {
//            if(s.charAt(i) == '(') {
//                sb1.append('(');
//                numOpenP++;
//            }
//            else if(s.charAt(i) == ')') {
//                if(numOpenP > 0) {
//                    sb1.append(')');
//                    numOpenP--;
//                }
//            }
//            else {
//                sb1.append(s.charAt(i));
//            }
//        }
//
//
//        int numCloseP = 0;
//        StringBuilder sb2 = new StringBuilder();
//        for(int i = sb1.length() - 1; i >= 0; i--) {
//            if(sb1.charAt(i) == ')') {
//                sb2.append(')');
//                numCloseP++;
//            }
//            else if(sb1.charAt(i) == '(') {
//                if(numCloseP > 0) {
//                    sb2.append('(');
//                    numCloseP--;
//                }
//            }
//            else {
//                sb2.append(s.charAt(i));
//            }
//        }
//        return sb2.reverse().toString();
//    }
}
