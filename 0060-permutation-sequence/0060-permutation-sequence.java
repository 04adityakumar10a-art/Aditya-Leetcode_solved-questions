class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int fact = 1;

        // compute (n-1)!
        for (int i = 1; i < n; i++) {
            fact *= i;
        }

        // store numbers 1..n
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        k--;  // make it 0-based
        StringBuilder ans = new StringBuilder();

        while (numbers.size() > 0) {
            int index = k / fact;
            ans.append(numbers.get(index));
            numbers.remove(index);

            k = k % fact;
            if (numbers.size() > 0)
                fact = fact / numbers.size();
        }

        return ans.toString();
    }
}
