class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        cur.add(0);
        bfs(0,cur,ans,graph);
        return ans;
        
    }
    public void bfs(int start,List<Integer> cur,List<List<Integer>> ans,int[][]graph){
            if(start==graph.length-1) {
                ans.add(new ArrayList<>(cur));
                return;
            }
            for(int nbr :graph[start]){
                cur.add(nbr);
                bfs(nbr,cur,ans,graph);
                cur.remove(cur.size()-1);
            }
    }
}