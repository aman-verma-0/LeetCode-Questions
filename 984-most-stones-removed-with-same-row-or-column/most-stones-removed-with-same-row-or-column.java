class Solution {
    class DSU{
        int[]parent;
        int[]rank;
        DSU(int n){
            parent=new int[n+1];
            rank=new int[n+1];
            for(int i=1;i<=n;i++){
                parent[i]=i;
            }
        }
        public void union(int a,int b){
            int pa=find(a);
            int pb=find(b);
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
        }
        public int find(int a){
            if(parent[a]==a) return a;
            return parent[a]=find(parent[a]);
        }
    }
    public int removeStones(int[][] stones) {
        int n=stones.length;
        DSU obj=new DSU(n);
        int totalCom=n;
        for(int i=0;i<n;i++){
            int r1=stones[i][0];
            int c1=stones[i][1];
            for(int j=i+1;j<n;j++){
                int r2=stones[j][0];
                int c2=stones[j][1];
                if(r1==r2 || c1==c2){
                    int pa=obj.find(i);
                    int pb=obj.find(j);
                    if(pa!=pb){
                        totalCom--;
                    }
                    obj.union(i,j);
                }
                
            }
        }
        return n-totalCom;

        
    }
}