class Solution {
    public long countCommas(long n) {
        if(n<1000) return 0;
        long num=1000, count=0;
        while(num<=n){
            count+=n-num+1;
            num=num*1000;
        }
        return count;

        
    }
}