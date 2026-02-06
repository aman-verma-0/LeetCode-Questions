class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        // Map<Character,Integer>map=new HashMap<>();
        // int left=0,count=0;
        // for(int right=0;right<n;right++){
        //     char ch=s.charAt(right);
        //     map.put(ch,map.getOrDefault(ch,0)+1);
            // while(map.size()==3){                        //using map 
        //         count+=(n-right);
        //         char chl=s.charAt(left);
        //         map.put(chl,map.get(chl)-1);
        //         if(map.get(chl)==0) map.remove(chl);
        //         left++;
        //     }
        // }
        // return count;
        int[]freq=new int[3];
        int left=0,count=0;
        for(int right=0;right<n;right++){
            char ch=s.charAt(right);
            freq[ch-'a']++;
            while(freq[0]>0 && freq[1]>0 && freq[2]>0){
                count+=(n-right);
                freq[s.charAt(left)-'a']--;
                left++;
            }
        }
        return count;
        
    }
}