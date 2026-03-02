class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] trailingZeros = new int[n];

        // Step 1: Count trailing zeros in each row
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0 && grid[i][j] == 0; j--) {
                count++;
            }
            trailingZeros[i] = count;
        }

        int swaps = 0;

        // Step 2: Try to place correct row at each position
        for (int i = 0; i < n; i++) {
            int required = n - i - 1;
            int j = i;

            while (j < n && trailingZeros[j] < required) {
                j++;
            }

            if (j == n) return -1; // No suitable row found

            // Bubble up row j to position i
            while (j > i) {
                int temp = trailingZeros[j];
                trailingZeros[j] = trailingZeros[j - 1];
                trailingZeros[j - 1] = temp;
                swaps++;
                j--;
            }
        }

        return swaps;
    }
}