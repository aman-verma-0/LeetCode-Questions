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
            if(pa==pb) return;
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
        public int find(int node){
            if(parent[node]==node) return node;
            return parent[node]=find(parent[node]);
        }
    }
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<Integer>ans=new ArrayList<>();
        DSU obj=new DSU(n);
        obj.union(0,firstPerson);
        Arrays.sort(meetings,(a,b)->Integer.compare(a[2],b[2]));
        int i=0;
        while(i<meetings.length){
            int time=meetings[i][2];
            List<Integer>person=new ArrayList<>();
            int j=i;
            while(j<meetings.length && meetings[j][2]==time){
                int x=meetings[j][0];
                int y=meetings[j][1];
                obj.union(x,y);
                person.add(x);
                person.add(y);
                j++;
            }
            for(int p:person){
                int pp=obj.find(p);
                int up=obj.find(0);
                if(pp!=up) obj.parent[p]=p;
            }
            i=j;


            
        
        }
        int upp=obj.find(0);
        for(int k=0;k<n;k++){
            if(obj.find(k)==upp){
                ans.add(k);
            }

        }
        return ans;


        
    }
}