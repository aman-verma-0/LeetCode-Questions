class Solution {
    public int minJumps(int[] arr) {
        int n=arr.length;
        Map<Integer,List<Integer>>map=new HashMap<>();
        for(int i=0;i<n;i++){
            int num=arr[i];
            if(!map.containsKey(num)){
                map.put(num,new ArrayList<>());
                
            }
            map.get(num).add(i);
        }
        boolean[]vis=new boolean[n];
        vis[0]=false;
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        int step=0;
        while(!q.isEmpty()){
            int size=q.size();
            
            while(size-- >0){
                int curIdx=q.poll();
                if(curIdx==n-1) return step;
                if(curIdx-1>=0 && !vis[curIdx-1]){
                    vis[curIdx-1]=true;
                    q.add(curIdx-1);
                }
                if(curIdx+1<n && !vis[curIdx+1]){
                    vis[curIdx+1]=true;
                    q.add(curIdx+1);
                }
                if(map.containsKey(arr[curIdx])){
                    int s=map.get(arr[curIdx]).size();
                    for(int i=0;i<s;i++){
                        int idx=map.get(arr[curIdx]).get(i);
                        if(idx!=curIdx && !vis[idx]){
                            vis[idx]=true;
                            q.add(idx);
                        }
                    }map.remove(arr[curIdx]);
                }
            }
            step++;
        }
        return -1;

        
    }
}