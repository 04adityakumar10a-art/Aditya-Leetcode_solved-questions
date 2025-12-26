class Solution {
    public int romanToInt(String s) {
        int value = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put( 'M',1000);
        hm.put('D',500);
        hm.put('C',100);
        hm.put('L',50);
        hm.put('X',10);
        hm.put('V',5);
        hm.put('I',1);
        for (int i = 0; i < s.length(); i++) {
            int curr = hm.get(s.charAt(i));
            int next;
            if (i + 1 < s.length()) {
                next = hm.get(s.charAt(i + 1));
            } else {
                next = 0;
            }
            if (curr < next) value -= curr;
            else value += curr;
        }
        return value; }
}