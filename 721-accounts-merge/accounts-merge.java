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
        public int find(int a){
            if(parent[a]==a) return a;
            return parent[a]=find(parent[a]);
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        List<List<String>>ans=new ArrayList<>();
        DSU obj=new DSU(n);
        Map<String,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail=accounts.get(i).get(j);
                if(!map.containsKey(mail)){
                    map.put(mail,i);
                }
                else{
                    int a=map.get(mail);
                    obj.union(a,i);
                }

            }
        }
        List<List<String>> merged=new ArrayList<>();
        for(int i=0;i<n;i++){
            merged.add(new ArrayList<>());
        }
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            String key=entry.getKey();
            int value=entry.getValue();
            int pv=obj.find(value);
            merged.get(pv).add(key);
        }
        for(int i=0;i<n;i++){
            if(merged.get(i).size()==0) continue;
            Collections.sort(merged.get(i));
            merged.get(i).add(0,accounts.get(i).get(0));
            ans.add(merged.get(i));
        }
        return ans;


        
    }
}