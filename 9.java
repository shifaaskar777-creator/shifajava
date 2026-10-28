
class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers and numbers ending in 0
        // (except 0 itself) cannot be palindromes.
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversed = 0;

        while (x > reversed) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }

        // Even digits: x == reversed
        // Odd digits: x == reversed / 10 (ignore middle digit)
        return x == reversed || x == reversed / 10;
    }
}
