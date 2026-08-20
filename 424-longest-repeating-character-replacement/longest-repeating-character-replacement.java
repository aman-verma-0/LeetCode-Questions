class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int maxLen=0;
        int left=0,right=0;
        int mostFreq=0;
        Map<Character,Integer> map=new HashMap<>();
        while(right<n){
            char ch=s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            mostFreq=Math.max(mostFreq,map.get(ch));
            int windowSize=right-left+1;
            int req=windowSize-mostFreq;
            while(req>k){
                char cur=s.charAt(left);
                map.put(cur,map.get(cur)-1);
                if(map.get(cur)==0) map.remove(cur);
                left++;
                windowSize=right-left+1;
                req=windowSize-mostFreq;
            }
            maxLen=Math.max(maxLen,right-left+1);
            right++;


        }
        return maxLen;
        
    }
}