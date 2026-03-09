class Solution {
    class DSU{
        int[]parent;
        DSU(int n){
            parent=new int[n+1];
            for(int i=1;i<=n;i++){
                parent[i]=i;
            }
        }
        public void union(int a,int b){
            int pa=find(a);
            int pb=find(b);
            if(pa!=pb){
                parent[pb]=pa;
            }
        }
        public int find(int node){
            if(parent[node]==node) return node;
            return parent[node]=find(parent[node]);
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        DSU obj=new DSU(n);
        for(int i=0;i<n;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            if(obj.find(u)==obj.find(v)) return new int[]{u,v};
            else obj.union(u,v);
        }
        return new int[]{-1,-1};
        
    }
}