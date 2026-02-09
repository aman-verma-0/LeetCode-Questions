class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            list.get(u).add(v);
            list.get(v).add(u);

        }
        boolean isvisited[]=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        q.add(source);
        isvisited[source]=true;
        while(q.size()>0){
            int curr=q.poll();
            for(int i=0;i<list.get(curr).size();i++){
                int neigbhor=list.get(curr).get(i);
                if(!isvisited[neigbhor]){
                    q.add(neigbhor);
                    isvisited[neigbhor]=true;
                }
            }
        }
        return isvisited[destination];
        
    }
}