class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n=passingFees.length;
        int m=edges.length;
        List<List<int[]>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int from=edges[i][0];
            int to=edges[i][1];
            int time=edges[i][2];
            adj.get(from).add(new int[]{to,time});
            adj.get(to).add(new int[]{from,time});
        }

        int[][]dist=new int[n][maxTime+1];
        for(int rows[]:dist){
            Arrays.fill(rows,Integer.MAX_VALUE);
        }
        dist[0][0]=passingFees[0];
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        pq.add(new int[]{0,passingFees[0],0});
        while(!pq.isEmpty()){
            int[]cur=pq.poll();
            int curNode=cur[0];
            int curCost=cur[1];
            int curTime=cur[2];
            if(curNode==n-1) return curCost;
            if(curCost>dist[curNode][curTime]) continue;
            for(int[]neigh:adj.get(curNode)){
                int nbr=neigh[0];
                int nbrTime=neigh[1];
                int nbrCost=passingFees[nbr];
                int newTime=curTime+nbrTime;
                int newCost=curCost+nbrCost;
                if(newTime>maxTime) continue;
                if(newCost<dist[nbr][newTime]){
                    dist[nbr][newTime]=newCost;
                    pq.add(new int[]{nbr,newCost,newTime});
                }
            }
        }
        return -1;
        
    }
}