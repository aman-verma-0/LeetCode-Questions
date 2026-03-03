class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder s=nthString(n);
        return s.charAt(k-1);

        
    }
    public StringBuilder nthString(int n){
        if(n==1) return new StringBuilder("0");
        StringBuilder prev=nthString(n-1);
        String prevInverted=revInvertBits(prev);
        return prev.append("1").append(prevInverted);
    }
    public String revInvertBits(StringBuilder s){
        int n=s.length();
        char[]arr=new char[n];
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1'){
                arr[n-i-1]='0';
            }else arr[n-i-1]='1';
        }
        return new String(arr);
    }
}