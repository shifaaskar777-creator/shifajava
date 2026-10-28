import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] fact = new int[n + 1];

        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
            numbers.add(i);
        }

        k--; // Convert to zero-based index
        StringBuilder result = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            int index = k / fact[i];

            result.append(numbers.get(index));
            numbers.remove(index);

            k %= fact[i];
        }

        return result.toString();
    }
}
