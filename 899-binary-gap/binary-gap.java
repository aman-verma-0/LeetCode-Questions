class Solution {
    public int binaryGap(int n) {
        String binary=Integer.toBinaryString(n);
        int size=binary.length();
        int left=0;
        int right=0;
        int max=0;
        boolean atleastone=false;
        while(right<size){
            if(binary.charAt(right)=='1'){
                if(atleastone==true){
                    max=Math.max(max,(right-left));
                }
                left=right;
                atleastone=true;
            }
            right++;
        }
        return max;

    
        
    }
}