// Use a while loop, create a StringBuilder to start with "0". while Sn is not reached, keep doing:
// Convert Si-1 to Si according to the instruction
// After the while loop, Get the kth bit from the final StringBuilder
// Edge Case: n is 1, return '0';
// Time: O(n^2), Space: O(n)

class Solution {
    public static void main(String[] args) {
        System.out.print(new Solution().findKthBit(4, 11));
    }
    public char findKthBit(int n, int k) {
        if(n == 1) {
            return '0';
        }

        StringBuilder sb = new StringBuilder("0");
        int index = 1;
        while(index < n) {
            StringBuilder copy = new StringBuilder(sb);
            for(int i = 0; i < copy.length(); i++) {
                if(copy.charAt(i) == '0') {
                    copy.setCharAt(i, '1');
                }
                else {
                    copy.setCharAt(i, '0');
                }
            }
            sb.append("1").append(copy.reverse().toString());
            index++;
        }

        return sb.charAt(k-1);
    }
}
