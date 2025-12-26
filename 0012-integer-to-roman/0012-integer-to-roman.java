class Solution {
public String helper(StringBuilder s,int n)
{ int copy=n;
if(copy==0) return s.toString();
else if(copy/1000 >= 1) 
 return helper(s.append("M"),n-1000);   
else if(copy/900 >=1)
return helper(s.append("CM"),n-900);
 else if(copy/500 >=1)
return helper(s.append("D"),n-500);
else if(copy/400 >=1)
return helper(s.append("CD"),n-400);
else if(copy/100 >=1)
return helper(s.append("C"),n-100);
else if(copy/90 >=1)
return helper(s.append("XC"),n-90);
else if(copy/50 >=1)
return helper(s.append("L"),n-50);
else if(copy/40 >=1)
return helper(s.append("XL"),n-40);
else if(copy/10 >=1)
return helper(s.append("X"),n-10);
else if(copy/9 >=1)
return helper(s.append("IX"),n-9);
else if(copy/5 >=1)
return helper(s.append("V"),n-5);
else if(copy/4 >=1)
return helper(s.append("IV"),n-4);
else 
return helper(s.append("I"),n-1);
}
 public String intToRoman(int num)
 {
     StringBuilder s=new StringBuilder("");
     helper(s,num);
     return s.toString();
    }
}