class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        ArrayList<Integer> ans = new ArrayList<>();
        String ref = "123456789";
        int lcount = String.valueOf(low).length();
        int hcount = String.valueOf(high).length();
        while (lcount <= hcount) {
            //sliding window

            int window = lcount;

            for (int right = 0; right < ref.length()-lcount+1; right++) {

                String s = ref.substring(right,right+lcount);
                int answer = Integer.valueOf(s);
                if(answer <= high && answer >= low) ans.add(answer);
            }

            lcount++;

        }
        return ans;
    }
}