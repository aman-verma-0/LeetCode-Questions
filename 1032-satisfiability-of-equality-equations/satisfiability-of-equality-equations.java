class Solution {
    class DSU{
        int[]parent;
        int []rank;
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
            if(pa==pb){
                return;
            }
            else if(rank[pa]>rank[pb]){
                parent[pb]=pa;
            }
            else if(rank[pb]<rank[pa]){
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
    public boolean equationsPossible(String[] equations) {
        DSU obj=new DSU(26);
        int n=equations.length;
        for(int i=0;i<n;i++){
            if(equations[i].charAt(1)=='='){
                int a=equations[i].charAt(0)-'a';
                int b=equations[i].charAt(3)-'a';
                obj.union(a,b);
            }
        }
        for(int i=0;i<n;i++){
            if(equations[i].charAt(1)=='!'){
                int a=equations[i].charAt(0)-'a';
                int b=equations[i].charAt(3)-'a';
                int pa=obj.find(a);
                int pb=obj.find(b);
                if(pa==pb) return false;
            }
        }return true;
        
    }
}