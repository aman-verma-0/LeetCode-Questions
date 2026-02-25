class Solution {
    class Pair{
        int node;
        long time;
        public Pair(int node,long time){
            this.node=node;
            this.time=time;
        }
    }
    public int countPaths(int n, int[][] roads) {
        int mod=1000000007;
        int m=roads.length;
        List<List<Pair>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        long[]dist=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        long[] ways = new long[n];
        ways[0]=1;
        for(int i=0;i<m;i++){
            int u=roads[i][0];
            int v=roads[i][1];
            int t=roads[i][2];
            adj.get(u).add(new Pair(v,t));
            adj.get(v).add(new Pair(u,t));
        }
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->Long.compare(a.time,b.time));
        pq.add(new Pair(0,0));
        dist[0]=0;
        while(!pq.isEmpty()){
            Pair cur=pq.poll();
            int curNode=cur.node;
            long curTime=cur.time;
            if(curTime>dist[curNode]) continue;
            for(Pair neigh:adj.get(curNode)){
                int nbr=neigh.node;
                long nbrTime=neigh.time;
                long newTime=curTime+nbrTime;
                if(newTime<dist[nbr]){
                    dist[nbr]=newTime;
                    ways[nbr]=ways[curNode];
                    pq.add(new Pair(nbr,newTime));
                }
                else if(newTime == dist[nbr]) {
                    ways[nbr] = (ways[nbr] + ways[curNode]) % mod;
                }

            }
        }
        return (int)ways[n-1]%mod;
        // long shortestTime=dist[n-1];
        // int count=0;
        // for(Pair destNbr:adj.get(n-1)){
        //     int prevNode=destNbr.node;
        //     long time=destNbr.time;
        //     if(dist[prevNode]+time==shortestTime) count++;
        // }
        // return count;
        
    }
}