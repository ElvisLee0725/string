// Convert input string to lowercase
// Create an string of vowels. Use numVow1 and numVow2 to store the number of vowels in 1st and 2nd half of string
// Iterate the input string and count the number of vowels in the first and 2nd half of the string
// Return true if the numbers are equal
// Time: O(n), Space: O(1);
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().halvesAreAlike("Leetcode"));
    }
    public boolean halvesAreAlike(String s) {
        String vowels = "aeiouAEIOU";
        int numVow1 = 0;
        int numVow2 = 0;
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(i < s.length() / 2) {
                if(vowels.indexOf(cur) != -1) numVow1++;
            }
            else {
                if(vowels.indexOf(cur) != -1) numVow2++;
            }
        }
        return numVow1 == numVow2;
    }
}
