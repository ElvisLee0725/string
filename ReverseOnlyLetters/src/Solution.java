// Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place,
// and all letters reverse their positions.

// Solution:
// Use 2 pointers i and j, i starts from 0 and j starts from the end
// In a while loop where i < j, check if 2 pointers are pointing at lower or upper case letter? If so, swap them and move both i and j
// Else, move the pointer not pointing at a letter by 1
// Edge Case: S is null or length <= 1, just return it
// Time: O(n), Space: O(1)

class Solution {
    public static void main(String[] args) {
        System.out.print(new Solution().reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
    public String reverseOnlyLetters(String S) {
        if(S == null || S.length() <= 1) {
            return S;
        }
        char [] arr = S.toCharArray();
        int i = 0;
        int j = S.length()-1;
        while(i < j) {
            if(Character.isAlphabetic(arr[i]) && Character.isAlphabetic(arr[j])) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
            else {
                if(!Character.isAlphabetic(arr[i])) {
                    i++;
                }
                if(!Character.isAlphabetic(arr[j])) {
                    j--;
                }
            }
        }
        return new String(arr);
    }
}
