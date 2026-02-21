class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count=0;
        for(int i=left;i<=right;i++){
            // String binary=Integer.toBinaryString(i);
            // int setBits=countSetBits(binary);
            int setBits=Integer.bitCount(i);
            if(isPrime(setBits)) count++;
        }
        return count;
        
    }
    // public int countSetBits(String num){
    //     int n=num.length();
    //     int count=0;
    //     for(int i=0;i<n;i++){
    //         if(num.charAt(i)=='1') count++;
    //     }
    //     return count;
    // }
    public boolean isPrime(int num){
        if(num<2) return false;
        if(num==2) return true;
        if(num%2==0) return false;
        for(int i=3;i*i<=num;i++){
            if(num%i==0) return false;
        }
        return true;
    }
}