class Solution {
    public long sumAndMultiply(int n) {
        long sum =0;
        long x=0 ,i=0,place=1;
    while (n > 0) {
        long digit = n % 10;
        if (digit != 0) {
            x += digit * place;
            sum+=digit;
            place *= 10;
        }
        n /= 10;
    }
    return sum*x;
    }
}