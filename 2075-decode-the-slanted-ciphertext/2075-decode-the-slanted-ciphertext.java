class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
       // no of cols= str.length/rows +1 
       int length= encodedText.length();
       int cols= (length/rows)+1;
       if (rows==1) return encodedText;
       int j=0;
       int i=0;
       StringBuilder original = new StringBuilder();
       
       while(original.length()<length)
       { 
          original.append(encodedText.charAt(i));
          i=i+cols;
           if(i>length-1) 
           {
            j++;
            i=j;
           }
       }
       return original.toString().stripTrailing();
    }
}