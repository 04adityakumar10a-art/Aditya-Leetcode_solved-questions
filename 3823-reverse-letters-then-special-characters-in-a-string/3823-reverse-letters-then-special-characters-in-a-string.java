class Solution {
    public String reverseByType(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        // 1️⃣ Reverse letters
        int l = 0, r = n - 1;
        while (l < r) {
            if (!Character.isLetter(arr[l])) l++;
            else if (!Character.isLetter(arr[r])) r--;
            else {
                char temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
        }

        // 2️⃣ Reverse special characters
        l = 0;
        r = n - 1;
        while (l < r) {
            if (Character.isLetter(arr[l])) l++;
            else if (Character.isLetter(arr[r])) r--;
            else {
                char temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
        }

        return new String(arr);
    }
}
