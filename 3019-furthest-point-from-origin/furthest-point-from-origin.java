class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int n=moves.length();
        int LCount=0,RCount=0,NoTag=0;
        for(int i=0;i<n;i++){
            if(moves.charAt(i)=='L') LCount++;
            else if(moves.charAt(i)=='R') RCount++;
            else NoTag++;

        }
        return Math.abs(LCount-RCount)+NoTag;
        
    }
}