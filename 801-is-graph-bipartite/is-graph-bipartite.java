class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[]outDeg=new int[n];
        // for(int i=0;i<n;i++){
        //     outDeg[i]+=graph[i].length;
        // }
        int[]color=new int[n];
        Arrays.fill(color,-1);
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(!bfs(i,graph,q,color)){
                    return false;
                }
            }
        }
        return true;

        
        
    }
    public boolean bfs(int start,int[][]graph,Queue<int[]>q,int[]color){
        q.add(new int[]{start,0});
        color[start]=0;
        while(!q.isEmpty()){
            int cur[]=q.poll();
            int curNode=cur[0];
            int clr=cur[1];
            for(int nbr:graph[curNode]){
                if(color[nbr]==-1){
                    color[nbr]=1-clr;
                    q.add(new int[]{nbr,color[nbr]});
                }
                else if(color[nbr]==clr){
                    return false;
                }
            }

        }
        return true;


    }
}