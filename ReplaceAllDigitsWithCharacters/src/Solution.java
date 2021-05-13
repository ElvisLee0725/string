// You are given a 0-indexed string s that has lowercase English letters in its even indices and digits in its odd indices.
//
// There is a function shift(c, x), where c is a character and x is a digit, that returns the xth character after c.
//
// For example, shift('a', 5) = 'f' and shift('x', 0) = 'x'.
// For every odd index i, you want to replace the digit s[i] with shift(s[i-1], s[i]).

//Return s after replacing all digits. It is guaranteed that shift(s[i-1], s[i]) will never exceed 'z'.

// Convert the input string to a char array
// Iterate each odd index of the char array, assign arr[i] to the return of shift(arr[i-1], arr[i])
// Convert the char array back to string, then return it.
// Time: O(n), Space: O(n)
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().replaceDigits("a1b2c3d4e"));
    }
    public String replaceDigits(String s) {
        char [] arr = s.toCharArray();
        for(int i = 1; i < arr.length; i += 2) {
            arr[i] = shift(arr[i-1], arr[i] - '0');
        }
        return new String(arr);
    }

    private char shift(char ch, int val) {
        return (char) (ch + val);
    }
}
