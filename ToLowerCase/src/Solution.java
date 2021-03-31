// Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.

// Iterate the input string, for each letter, map it to its lower case letter
// Firstly, check if current char is alphabetic?
// A is 65, a is 97
// For each uppercase letter, + 32 to convert it to lowercase letter
// Time: O(n), Space: O(n)
class Solution {
    public static void main(String[] args) {
        System.out.print(new Solution().toLowerCase("al&phaBET"));
    }
    public String toLowerCase(String str) {
        if(str == null || str.length() == 0) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch >= 'A' && ch <= 'Z') {
                sb.append((char) (ch + 32));
            }
            else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}