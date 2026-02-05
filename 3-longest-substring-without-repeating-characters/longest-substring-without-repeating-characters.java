class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int left=0;
        int maxLen=0;
        int right=0;
        Set<Character> map=new HashSet<>();
        while(right<n){
            if(!map.contains(s.charAt(right))){
                map.add(s.charAt(right));
                maxLen=Math.max(map.size(),maxLen);
            }
            else{
                while(map.contains(s.charAt(right))){
                    map.remove(s.charAt(left));
                    left++;
                }
                map.add(s.charAt(right));
            }
            right++;
        }
        return maxLen;
        
        
    }
}