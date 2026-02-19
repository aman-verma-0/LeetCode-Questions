class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n=prerequisites.length;
        List<List<Integer>>adjList=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }
        int[]indeg=new int[numCourses];
        for(int i=0;i<n;i++){
            int to=prerequisites[i][0];
            int from=prerequisites[i][1];
            adjList.get(from).add(to);
            indeg[to]+=1;
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0) q.add(i);
        }
        int count=0;
        while(!q.isEmpty()){
            int cur=q.poll();
            count++;
            for(int nbr:adjList.get(cur)){
                indeg[nbr]-=1;
                if(indeg[nbr]==0) q.add(nbr);
            }

        }
        return (count==numCourses);
        
    }
}