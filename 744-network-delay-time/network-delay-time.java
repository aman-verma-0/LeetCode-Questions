class Solution {
    // class Pair{
    //     int node;
    //     int weight;
    //     Pair(int node,int weight){
    //         this.node=node;
    //         this.weight=weight;
    //     }
    // }
    public int networkDelayTime(int[][] times, int n, int k) {
        int m=times.length;
        int[]dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        for(int i=1;i<=n-1;i++){
            for(int j=0;j<m;j++){
                int u=times[j][0];
                int v=times[j][1];
                int w=times[j][2];
                if(dist[u]==Integer.MAX_VALUE) continue;
                if(dist[u]+w<dist[v]){
                    dist[v]=dist[u]+w;
                }

            }
        }
        // for(int j=0;j<m;j++){
        //     int u=times[j][0];
        //     int v=times[j][1];
        //     int w=times[j][2];
        //     if(dist[u]!=Integer.MAX_VALUE && dist[u]+w<dist[v]){
        //         return -1;
        //     }

        // }
        int maxValue=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            maxValue=Math.max(dist[i],maxValue);
            

        }
        return maxValue;
        // List<List<Pair>>adj=new ArrayList<>();
        // for(int i=0;i<=n;i++){
        //     adj.add(new ArrayList<>());
        // }
        // int edge=times.length;
        // for(int i=0;i<edge;i++){
        //     int u=times[i][0];
        //     int v=times[i][1];
        //     int wt=times[i][2];
        //     adj.get(u).add(new Pair(v,wt));
        // }
        // PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->Integer.compare(a.weight,b.weight));
        // int[]time=new int[n+1];
        // Arrays.fill(time,Integer.MAX_VALUE);
        // q.add(new Pair(k,0));
        // time[k]=0;
        // while(!q.isEmpty()){
        //     Pair cur=q.poll();
        //     int curNode=cur.node;
        //     int curTime=cur.weight;
        //     for(Pair nb:adj.get(curNode)){
        //         int neigh=nb.node;
        //         int t=nb.weight;
        //         if(time[curNode]+t<time[neigh]){
        //             time[neigh]=time[curNode]+t;
        //             q.add(new Pair(neigh,time[neigh]));
        //         }
        //     }
        // }
        // int max=0;
        // for(int i=1;i<=n;i++){
        //     if(time[i]==Integer.MAX_VALUE){
        //         return -1;
        //     }
        //     max=Math.max(max,time[i]);
        // }
        // return max;
    
    }
}
