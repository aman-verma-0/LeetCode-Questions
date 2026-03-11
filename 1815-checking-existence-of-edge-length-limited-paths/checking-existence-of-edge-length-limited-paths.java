class Solution {
    class DSU{
        int[]parent;
        int[]rank;
        DSU(int n){
            parent=new int[n];
            rank=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }

        }
        public void union(int a,int b){
            int pa=find(a);
            int pb=find(b);
            if(pa==pb) return ;
            if(rank[pa]>rank[pb]){
                parent[pb]=pa;
            }
            else if(rank[pb]>rank[pa]){
                parent[pa]=pb;
            }else{
                parent[pb]=pa;
                rank[pa]++;
            }
        }
        public int find(int node){
            if(parent[node]==node) return node;
            return parent[node]=find(parent[node]);
        }
    }
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int el=edgeList.length;
        int ql=queries.length;
        int[][]q=new int[ql][4];
        for(int i=0;i<ql;i++){
            q[i][0]=queries[i][0];
            q[i][1]=queries[i][1];
            q[i][2]=queries[i][2];
            q[i][3]=i;
            
        }
        Arrays.sort(edgeList,(a,b)->Integer.compare(a[2],b[2]));
        Arrays.sort(q,(a,b)->Integer.compare(a[2],b[2]));
        DSU obj=new DSU(n);
        int edgeIdx=0;
        boolean[]ans=new boolean[ql];
        for(int i=0;i<ql;i++){
            int u=q[i][0];
            int v=q[i][1];
            int limit=q[i][2];
            int idx=q[i][3];
            while(edgeIdx<el && edgeList[edgeIdx][2]<limit){
                int a=edgeList[edgeIdx][0];
                int b=edgeList[edgeIdx][1];
                obj.union(a,b);
                edgeIdx++;
            }
            int pu=obj.find(u);
            int pv=obj.find(v);
            ans[idx]=(pu==pv);

        }
        return ans;
        
    }
}