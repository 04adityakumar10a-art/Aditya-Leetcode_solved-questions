class Solution {
    public String processStr(String s) {
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<s.length();i++)
        { 
            if(s.charAt(i)>='a' && s.charAt(i)<='z')
                sb.append(s.charAt(i));
             if(s.charAt(i)=='*')
             { if(sb.length()!=0)
                sb.deleteCharAt(sb.length()-1); }
             if(s.charAt(i)=='#')
                sb.append(sb); 
            if(s.charAt(i)=='%')
                sb.reverse();           
        }
        return sb.toString();
    }
}