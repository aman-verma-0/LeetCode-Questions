import java.util.*;

public class Solution {
    int[]dr={-1,1,-0,0,-1,-1,1,1};
    int[]dc={0,0,-1,1,1,-1,1,-1};
    public boolean isValid(int i,int j,int tRow,int tCol){
        if(i>=0 && i<tRow && j>=0 && j<tCol) return true;
        return false;
    }
    public List<List<Integer>> pacificAtlantic(int[][] height) {
        List<List<Integer>> ans= new ArrayList<>();
        int n =height.length;
        int m= height[0].length;

        boolean[][] pac= new boolean[n][m];
        boolean[][] atl= new boolean[n][m];

        Queue<int[]> pq= new LinkedList<>();
        Queue<int[]> aq= new LinkedList<>();

        // pacific boundary
        for(int i=0;i<n;i++){
            pac[i][0]=true;
            pq.offer(new int[]{i,0});
            // atlantic boundary
            atl[i][m-1]=true;
            aq.offer(new int[]{i,m-1});
        }
        for(int j=0;j<m;j++){
            pac[0][j]=true;
            pq.offer(new int[]{0,j});
            // atlantic boundary
            atl[n-1][j]=true;
            aq.offer(new int[]{n-1,j});
        }

        bfs(pq,pac,height);
        bfs(aq,atl,height);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pac[i][j] && atl[i][j]){
                    ans.add(new ArrayList<>(Arrays.asList(i,j)));
                }
            }
        }

        return ans;

        
    }
    public void bfs(Queue<int[]>q,boolean[][]canFlow,int[][]height){
        while(!q.isEmpty()){
            int[]curr=q.poll();
            int row=curr[0];
            int col=curr[1];
            int curValue=height[row][col];
            for(int k=0;k<4;k++){
                int newRow=row+dr[k];
                int newCol=col+dc[k];
                if(isValid(newRow,newCol,height.length,height[0].length) && canFlow[newRow][newCol]==false && height[newRow][newCol]>=curValue){
                    canFlow[newRow][newCol]=true;
                    q.offer(new int[]{newRow,newCol});
                }
            }

        }
    }

    
}
