class Solution {
    public int mirrorDistance(int n) {
        int rev=reverse(n);
        int mDist=Math.abs(n-rev);
        return mDist;
        
    }
    public int reverse(int num){
        int n=0;
        while(num!=0){
            int rem=num%10;
            n=n*10+rem;
            num/=10;
        }
        return n;
    }
}