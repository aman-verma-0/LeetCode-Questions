class Solution {
    public boolean judgeCircle(String moves) {
        int startX=0;
        int startY=0;
        int n=moves.length();
        for(int i=0;i<n;i++){
            if(moves.charAt(i)=='U'){
                startX++;
            }
            if(moves.charAt(i)=='D'){
                startX--;
            }
            if(moves.charAt(i)=='L'){
                startY--;
            }
            if(moves.charAt(i)=='R'){
                startY++;
            }

        }
        if(startX==0 && startY==0) return true;
        return false;
        
    }
}