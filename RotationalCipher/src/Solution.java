public class Solution {
    public static void main(String[] args) {
        String input1 = "Zebra-493?";
        String input2 = "abcdefghijklmNOPQRSTUVWXYZ0123456789";
        System.out.println(new Solution().rotationalCipher(input1, 3));
    }

    // Iterate each characters in the array, check if it's a uppercase, lowercase or number?
    // Case 1: Uppercase letter, check if arr[i] + rotationFactor % 26 > 'Z'? If so, arr[i] = arr[i] + rotationFactor - 'Z' + 'A' - 1
    // Case 2: Lowercase letter, check if arr[i] + rotationFactor % 26 > 'z'? If so, arr[i] = arr[i] + rotationFactor - 'z' + 'a' - 1
    // Case 3: Number, check if arr[i] + rotationFactor % 10 > '9'? If so, arr[i] = arr[i] + rotationFactor - '9' + '0' - 1
    // Case 4: None of the above, do nothing
    // Return the char array by converting to string
    // Time: O(n), Space: O(1)

    String rotationalCipher(String input, int rotationFactor) {
        // Write your code here
        char[] arr = input.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 'A' && arr[i] <= 'Z') {
                int fac = rotationFactor % 26;
                arr[i] = arr[i] + fac > 'Z' ? (char) (arr[i] + fac - 'Z' + 'A' - 1) : (char) (arr[i] + fac);
            } else if (arr[i] >= 'a' && arr[i] <= 'z') {
                int fac = rotationFactor % 26;
                arr[i] = arr[i] + fac > 'z' ? (char) (arr[i] + fac - 'z' + 'a' - 1) : (char) (arr[i] + fac);
            } else if (arr[i] >= '0' && arr[i] <= '9') {
                int fac = rotationFactor % 10;
                arr[i] = arr[i] + fac > '9' ? (char) (arr[i] + fac - '9' + '0' - 1) : (char) (arr[i] + fac);
            }
        }
        return new String(arr);
    }

}