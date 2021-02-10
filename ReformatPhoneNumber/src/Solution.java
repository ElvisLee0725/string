// You are given a phone number as a string number. number consists of digits, spaces ' ', and/or dashes '-'.
// You would like to reformat the phone number in a certain manner. Firstly, remove all spaces and dashes. Then, group the digits from left to right into blocks of length 3 until there are 4 or fewer digits. The final digits are then grouped as follows:
// 2 digits: A single block of length 2.
// 3 digits: A single block of length 3.
// 4 digits: Two blocks of length 2 each.
// The blocks are then joined by dashes. Notice that the reformatting process should never produce any blocks of length 1 and produce at most two blocks of length 2.

// Return the phone number after formatting.

// Sol:
// Group 3 digits as many as possible, but if there are 4 digits left, group them as dd-dd
// If digits left are equal to 3 or less than 3 (ex 2), group them
// Count the number of digits from number string
// While the number of digits is greater than 0, do:
// Case 1: # of digits less then to 4, group all of them
// Case 2: # of digits left is 4, group to dd-dd
// Case 3: not case 1 or 2, group 3 digits
// Decrease the number of digits grouped, add '-' if there are digits left and continue the loop
// Time: O(n), Space: O(n)

class Solution {
    public static void main(String[] args) {
        System.out.print(new Solution().reformatNumber("--17-5 229 35-39475 "));
    }
    public String reformatNumber(String number) {
        int numOfDigit = 0;
        for(int i = 0; i < number.length(); i++) {
            if(number.charAt(i) >= '0' && number.charAt(i) <= '9') {
                numOfDigit++;
            }
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(numOfDigit > 0) {
            if(numOfDigit < 4) {
                while(index < number.length()) {
                    if(number.charAt(index) >= '0' && number.charAt(index) <= '9') {
                        sb.append(number.charAt(index));
                    }
                    index++;
                }
                numOfDigit = 0;
            }
            else if(numOfDigit == 4) {
                int count = 0;
                while(index < number.length()) {
                    if(number.charAt(index) >= '0' && number.charAt(index) <= '9') {
                        sb.append(number.charAt(index));
                        count++;
                        if(count == 2) {
                            sb.append("-");
                        }
                    }
                    index++;
                }
                numOfDigit = 0;
            }
            else {
                int count = 0;
                while(count < 3) {
                    if(number.charAt(index) >= '0' && number.charAt(index) <= '9') {
                        sb.append(number.charAt(index));
                        count++;
                    }
                    index++;
                }
                numOfDigit -= 3;
            }

            if(numOfDigit > 0) {
                sb.append("-");
            }
        }
        return sb.toString();
    }
}
