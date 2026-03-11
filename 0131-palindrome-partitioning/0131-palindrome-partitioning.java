class Solution {

    public List<List<String>> partition(String s) {

        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        // Precompute palindrome table
        for(int end = 0; end < n; end++){
            for(int start = 0; start <= end; start++){

                if(s.charAt(start) == s.charAt(end) &&
                   (end - start <= 2 || dp[start+1][end-1])){

                    dp[start][end] = true;
                }
            }
        }

        List<List<String>> res = new ArrayList<>();
        backtrack(0, s, dp, new ArrayList<>(), res);

        return res;
    }

    void backtrack(int start, String s, boolean[][] dp,
                   List<String> path, List<List<String>> res){

        if(start == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int end = start; end < s.length(); end++){

            if(dp[start][end]){

                path.add(s.substring(start, end + 1));

                backtrack(end + 1, s, dp, path, res);

                path.remove(path.size() - 1);
            }
        }
    }
}