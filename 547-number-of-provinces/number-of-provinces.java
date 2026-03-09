class Solution {
    class DSU{
        int parent[];
        DSU(int n){
            parent=new int[n+1];
            for(int i=0;i<=n;i++){
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
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        DSU obj=new DSU(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    obj.union(i+1,j+1);
                }
            }
        }
        
        int ans=0;
        for(int k=1;k<=n;k++){
            if(obj.find(k)==k) ans++;

        }
        return ans;
    }
}