class Solution {
    class Pair{
        int node;
        int price;
        int steps;
        Pair(int node,int price,int steps){
            this.node=node;
            this.price=price;
            this.steps=steps;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int m=flights.length;
        List<List<int[]>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int u=flights[i][0];
            int v=flights[i][1];
            int p=flights[i][2];
            adj.get(u).add(new int[]{v,p});
        }
        int[][] dist = new int[n][k+2];
        for(int[] row : dist){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[src][0]=0;
        int count=0;

        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->Integer.compare(a.price,b.price));
        pq.add(new Pair(src,0,0));
        while(!pq.isEmpty()){
            Pair cur=pq.poll();
            int curNode=cur.node;
            int curPrice=cur.price;
            int curStep=cur.steps;
            if(curNode==dst) return curPrice;
            if(curStep>k) continue;
            for(int neigh[]:adj.get(curNode)){
                int nbr=neigh[0];
                int cost=neigh[1];
                if(curPrice+cost<dist[nbr][curStep+1]){
                    dist[nbr][curStep+1]=curPrice+cost;
                    pq.add(new Pair(nbr,dist[nbr][curStep+1],curStep+1));
                }
            }
            
        }
        return -1;
    }
}