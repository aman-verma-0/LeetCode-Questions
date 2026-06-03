class Solution {
    class Pair {
    char ch;
    int freq;

    Pair(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}
    public String reorganizeString(String s) {
        int n=s.length();
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->b.freq-a.freq);

        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            pq.offer(new Pair(entry.getKey(),entry.getValue()));
        }
        
        StringBuilder sb=new StringBuilder("");
        char prevCh='#';
        while(!pq.isEmpty()){
            Pair entry=pq.poll();
            if(entry.ch!=prevCh){
                sb.append(entry.ch);
                entry.freq--;
                prevCh=entry.ch;
                if(entry.freq>0){
                    pq.offer(entry);
                }     
            }
            else if(pq.isEmpty()) return new String("");
            else{

                Pair secEntry=pq.poll();
                sb.append(secEntry.ch);
                secEntry.freq--;
                prevCh=secEntry.ch;
                pq.offer(entry);
                if(secEntry.freq>0){
                    pq.offer(secEntry);
                }
            }

        }
        return sb.toString();

    }
}