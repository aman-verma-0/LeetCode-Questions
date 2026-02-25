class Solution {
    class Pair{
        int node;
        double prob;
        public Pair(int node,double prob){
            this.node=node;
            this.prob=prob;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        int m=edges.length;
        List<List<Pair>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        double[]dist=new double[n];
        Arrays.fill(dist,0.0);
        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            double sucp=succProb[i];
            adj.get(u).add(new Pair(v,sucp));
            adj.get(v).add(new Pair(u,sucp));
        }
        PriorityQueue<Pair>q=new PriorityQueue<>((a,b)->Double.compare(b.prob,a.prob));
        q.add(new Pair(start_node,1));
        dist[start_node]=1;
        while(!q.isEmpty()){
            Pair cur=q.poll();
            int curNode=cur.node;
            double prb=cur.prob;
            for(Pair neigh:adj.get(curNode)){
                int nbr=neigh.node;
                double nbrProb=neigh.prob;
                double newProb=prb*nbrProb;
                if(newProb>dist[nbr]){
                    dist[nbr]=newProb;
                    q.add(new Pair(nbr,newProb));
                }

            }
        }
        if(dist[end_node]==Integer.MIN_VALUE) return 0;
        return dist[end_node];
    }
}