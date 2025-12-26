class Solution {
    public int reverseBits(int n) {
        String str= String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0');

       StringBuffer st= new StringBuffer(str);
       String s = st.reverse().toString();
       return Integer.parseInt(s, 2);

    }
}