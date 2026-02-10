class Solution {
    public int findCenter(int[][] edges) {
        int first=edges[0][0];
        int second=edges[0][1];
        if(first==edges[1][0]) return first;
        else if(second==edges[1][0]) return second;
        return edges[1][1];
        // int edge=edges.length;
        // int nodes=edge+1;
        // ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
        // for(int i=0;i<=nodes;i++){ 
        //     adjList.add(new ArrayList<>());
        // }
        // for(int i=0;i<edges.length;i++){
        //     int from=edges[i][0];
        //     int to=edges[i][1];
        //     adjList.get(from).add(to);
        //     adjList.get(to).add(from);
            
        // }
        // for(int i=1;i<=nodes;i++){
        //     if(adjList.get(i).size()==edge){
        //         return i;
        //     }
        // }
        // return -1;
    }
    
}