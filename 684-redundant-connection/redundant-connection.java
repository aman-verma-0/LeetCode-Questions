class Solution {
    class DSU{
        int[]par;
        DSU(int n){
            par=new int[n+1];
            for(int i=1;i<=n;i++){
                par[i]=i;
            }
        }
        public void union(int a,int b){
            int pa=find(a);
            int pb=find(b);
            if(pa!=pb){
                par[pb]=pa;
            }
        }
        public int find(int node){
            if(par[node]==node) return node;
            return par[node]=find(par[node]);
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        DSU obj=new DSU(n);
        for(int i=0;i<n;i++){
            int nodeA=edges[i][0];
            int nodeB=edges[i][1];
            int parA=obj.find(nodeA);
            int parB=obj.find(nodeB);
            if(parA==parB) return new int[]{nodeA,nodeB};
            else obj.union(nodeA,nodeB);
        }
        return new int[]{-1,-1};
    }
}