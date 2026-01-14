class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
        int childCount = 0;
    }

    void insert(TrieNode root, String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
                curr.childCount++;
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }

    String getLCP(TrieNode root) {
        StringBuilder sb = new StringBuilder();
        TrieNode curr = root;

        while (curr.childCount == 1 && !curr.isEnd) {
            for (int i = 0; i < 26; i++) {
                if (curr.children[i] != null) {
                    sb.append((char)(i + 'a'));
                    curr = curr.children[i];
                    break;
                }
            }
        }
        return sb.toString();
    }

    public String longestCommonPrefix(String[] strs) {
        TrieNode root = new TrieNode();

        for (String s : strs) {
            insert(root, s);
        }

        return getLCP(root);
    }
}
