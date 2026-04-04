class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int length = encodedText.length();
        if (rows == 1) return encodedText;

        int cols = length / rows;  // fixed (no +1)

        StringBuilder original = new StringBuilder();

        for (int j = 0; j < cols; j++) {
            int i = j;
            while (i < length) {
                original.append(encodedText.charAt(i));
                i += cols + 1;
            }
        }

        // remove trailing spaces only
        int end = original.length() - 1;
        while (end >= 0 && original.charAt(end) == ' ') {
            end--;
        }

        return original.substring(0, end + 1);
    }
}