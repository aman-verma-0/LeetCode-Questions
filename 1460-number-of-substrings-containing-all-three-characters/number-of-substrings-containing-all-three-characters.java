class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        Map<Character,Integer>map=new HashMap<>();
        int left=0,count=0;
        for(int right=0;right<n;right++){
            char ch=s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.size()==3){
                count+=(n-right);
                char chl=s.charAt(left);
                map.put(chl,map.get(chl)-1);
                if(map.get(chl)==0) map.remove(chl);
                left++;
            }
        }
        return count;
        
    }
}