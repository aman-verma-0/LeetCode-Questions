class Solution {
    class Pair{
        String str;
        int len;
        public Pair(String str,int len){
            this.str=str;
            this.len=len;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        Set<String> set=new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;

        while(!q.isEmpty()){
            Pair cur=q.poll();
            String curStr=cur.str;
            int wt=cur.len;
            if(curStr.equals(endWord)) return wt;
            for(int i=0;i<beginWord.length();i++){
                StringBuilder sb=new StringBuilder(curStr);
                for(char j='a';j<='z';j++){
                    sb.setCharAt(i,j);
                    String st=sb.toString();
                    if(set.contains(st)){
                        q.add(new Pair(st,wt+1));
                        set.remove(st);
                    }
                }
            }
        }
        return 0;
        
    }
}