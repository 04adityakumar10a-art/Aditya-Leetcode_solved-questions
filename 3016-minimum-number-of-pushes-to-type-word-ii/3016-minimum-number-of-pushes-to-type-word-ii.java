class Solution {
    public int minimumPushes(String word) {
        int[] arr = new int[26];

        for (char ch : word.toCharArray()) {
            arr[ch - 'a']++;
        }

        Arrays.sort(arr);

        int ans = 0;
        int cost = 1;
        int count = 0;

        for (int i = 25; i >= 0; i--) {
            if (arr[i] == 0) break;

            ans += arr[i] * cost;
            count++;

            if (count % 8 == 0) {
                cost++;
            }
        }

        return ans;
    }
}