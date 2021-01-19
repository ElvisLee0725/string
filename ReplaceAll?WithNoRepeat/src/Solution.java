public class Solution {
    public static void main(String[] args) {
        System.out.print(new Solution().modifyString("??yw?ipkj?"));
    }

    // Find all '?' from the input string and replace them with lowercase letters.
// When replacing '?', make sure there is no consecutive repeating characters.
// Iterate the input string, if the letter at cur index is '?', find a char from 'a' to 'z' to replace it, make sure i-1 and i+1 doesn't have
// the same character
// Keep doing it until the end of loop
// Return the new string
// Edge Case: Just 1 character, return 'a' if it's a '?'
// Time: O(n), Space: O(n)

        public String modifyString(String s) {
            if(s.length() == 1) {
                return s.equals("?") ? "a" : s;
            }
            char [] arr = s.toCharArray();
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == '?') {
                    for(char j = 'a'; j <= 'z'; j++) {
                        if(i == 0) {
                            if(arr[i+1] != j) {
                                arr[i] = j;
                                break;
                            }
                        }
                        else if(i == arr.length-1) {
                            if(arr[i-1] != j) {
                                arr[i] = j;
                                break;
                            }
                        }
                        else {
                            if(arr[i-1] != j && arr[i+1] != j) {
                                arr[i] = j;
                                break;
                            }
                        }
                    }
                }
            }
            return new String(arr);
        }
}
