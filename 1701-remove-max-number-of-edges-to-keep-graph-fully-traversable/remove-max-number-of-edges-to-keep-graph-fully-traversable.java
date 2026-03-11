class Solution {
    class DSU{
        int parent[];
        int rank[];
        DSU(int n){
            parent=new int[n+1];
            rank=new int[n+1];
            for(int i=1;i<=n;i++){
                parent[i]=i;
            }
        }
        public boolean union(int a,int b){
            int pa=find(a);
            int pb=find(b);
            if(pa==pb) return false;
            if(rank[pa]>rank[pb]){
                parent[pb]=pa;
            }
            else if(rank[pb]>rank[pa]){
                parent[pa]=pb;
            }
            else{
                parent[pb]=pa;
                rank[pa]++;
            }
            return true;
        }
        public int find(int node){
            if(parent[node]==node) return node;
            return parent[node]=find(parent[node]);
        }
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU alice=new DSU(n);
        DSU bob=new DSU(n);

        Arrays.sort(edges,(a,b)->Integer.compare(b[0],a[0]));
        boolean[]visA=new boolean[n];
        boolean[]visB=new boolean[n];
        int removeEdges=0;
        for(int i=0;i<edges.length;i++){
            int t=edges[i][0];
            int u=edges[i][1];
            int v=edges[i][2];
            // int pa1=obj1.find(u);
            // int pa2=obj2.find(u);
            // int pb1=obj1.find(v);
            // int pb2=obj2.find(v);
        
            if(t==3){
                boolean a=alice.union(u,v);
                boolean b=bob.union(u,v);
                if(a==false && b==false) removeEdges++;
            }
            else if(t==2){
                boolean b=bob.union(u,v);
                if(b==false) removeEdges++;
            }
            else{
                boolean a=alice.union(u,v);
                if(a==false) removeEdges++;
            }
                
        }
        int compA=0;
        int compB=0;
        for(int i=1;i<=n;i++){
            if(alice.parent[i]==i) compA++;
            if(bob.parent[i]==i) compB++;
        }
        if(compA>1 || compB>1) return -1;
        return removeEdges;

        
    }
}