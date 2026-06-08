class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;
        if(groupSize==1) return true;
        if(n%groupSize!=0) return false;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int i=0;i<n;i++){
            map.put(hand[i],map.getOrDefault(hand[i],0)+1);
        }
        while(!map.isEmpty()){
            int key=map.firstKey();
            int freq=map.get(key);
            for(int i=0;i<groupSize;i++){
                if(!map.containsKey(key+i) || map.get(key+i)<freq){
                    return false;
                }if(map.get(key+i)==freq){
                    map.remove(key+i);
                }else{
                    map.put(key+i,map.get(key+i)-freq);
                }
            }
        }
        return true;
        
    }
}