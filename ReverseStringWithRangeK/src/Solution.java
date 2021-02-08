// Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.

// Edge Case: If k is greater than the length of s, reverse s. If k is 1, just return original string
// Reverse from 0 - k-1, k - 2k-1 remains the same, 2k - 3k-1 reverse, 3k - 4k-1 the same
// => reverse 0k to 0k+k-1, 2k to 2k+k-1 ..., until n * k is out of the range of s
// If nk+k-1 is out of the range of s, use s.length()-1 as the end index to reverse
// Time: O(n), Space: O(n)

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseStr("abcdefg", 2));
    }
    public String reverseStr(String s, int k) {
        if(k == 1) {
            return s;
        }
        char [] arr = s.toCharArray();
        if(k > arr.length) {
            reverse(arr, 0, arr.length-1);
            return new String(arr);
        }

        int n = 0;
        while(n * k < arr.length) {
            int start = n * k;
            int end = (n * k + k) - 1;
            if(end >= arr.length) {
                reverse(arr, start, arr.length-1);
            }
            else {
                reverse(arr, start, end);
            }
            n += 2;
        }
        return new String(arr);
    }

    public void reverse(char [] arr, int i, int j) {
        while(i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
