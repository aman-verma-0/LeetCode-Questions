class Solution {
    public int findCenter(int[][] edges) {
        int edge=edges.length;
        int nodes=edge+1;
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<=nodes;i++){ 
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int from=edges[i][0];
            int to=edges[i][1];
            adjList.get(from).add(to);
            adjList.get(to).add(from);
            
        }
        for(int i=0;i<=nodes;i++){
            if(adjList.get(i).size()==edge){
                return i;
            }
        }
        return -1;
    }
    
}