import java.util.*;

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {

        HashSet<Integer> set = new HashSet<>();

        // Store all prefixes from arr1
        for (int num : arr1) {
            while (num > 0) {
                set.add(num);
                num /= 10;
            }
        }

        int ans = 0;

        // Check prefixes of arr2
        for (int num : arr2) {

            int temp = num;

            while (temp > 0) {

                if (set.contains(temp)) {
                    ans = Math.max(ans, digits(temp));
                    break;
                }

                temp /= 10;
            }
        }

        return ans;
    }

    // Function to count digits
    public int digits(int n) {
        int count = 0;

        while (n > 0) {
            count++;
            n /= 10;
        }

        return count;
    }
}