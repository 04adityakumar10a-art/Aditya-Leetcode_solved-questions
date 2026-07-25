class Solution {
    public int maxProduct(int n) {
        int max1 = 0;
        int max2= 0;
        int arr[] = new int[10];
        while(n>0)
        {
            int rem = n%10;
            arr[rem]++;
             n/=10;  

        }
          int count=2; int ans=1;
        for(int i =9 ; i>=0;i--)
        {   
            while(arr[i]>0)
            {   if(count == 0) break;
                ans=ans*i;
                arr[i]--;
                count--;
            }
        }
        return ans;
    }
}