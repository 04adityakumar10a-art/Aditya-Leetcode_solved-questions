class Solution {
   int gcd(int a, int b) {
    return (b == 0) ? a : gcd(b, a % b);
}   
    public int gcdOfOddEvenSums(int n) {
        int odd=0;
        int even=0;
        for(int i=0; i<=2*n ; i++)
        {
            if(i%2==1)
             odd+=i;
            else even+=i;
        }

        return gcd(odd,even);
    }
}