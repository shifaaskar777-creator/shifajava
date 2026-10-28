
import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.isEmpty()) {
            return result;
        }

        String[] phone = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(digits, 0, new StringBuilder(), phone, result);

        return result;
    }

    private void backtrack(String digits, int index,
                           StringBuilder current,
                           String[] phone,
                           List<String> result) {
        // All digits have been processed
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = phone[digits.charAt(index) - '0'];

        for (char c : letters.toCharArray()) {
            current.append(c);

            backtrack(digits, index + 1, current, phone, result);

            // Backtrack: remove the last character
            current.deleteCharAt(current.length() - 1);
        }
    }
}
