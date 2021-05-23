// Create an array of strings with length 10
// Split the input string by space, iterate the array and for each word, check its last char (digit) and assgin it to the index of the result array.
// Convert the result string array to a string and return.
// Time: O(n), Space: O(n)
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().sortSentence("is2 sentence4 This1 a3"));
    }
    public String sortSentence(String s) {
        String [] res = new String[10];
        String [] arr = s.split(" ");
        for(String str : arr) {
            int idx = str.charAt(str.length() - 1) - '0';
            res[idx] = str.substring(0, str.length() - 1);
        }
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i = 0; i < res.length; i++) {
            if(res[i] != null) {
                sb.append(res[i]);
                if(count < arr.length) {
                    sb.append(" ");
                }
                count++;
            }
        }
        return sb.toString();
    }
}
