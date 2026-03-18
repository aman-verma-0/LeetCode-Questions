class Solution {
    public class SegamentTree{
        int[]segTree;
        SegamentTree(int n){
            segTree=new int[4*n];
        }
        void buildTree(int idx,int start,int end,int[]arr){
            if(start==end){
                segTree[idx]=arr[start];
                return;
            }
            int mid=start+(end-start)/2;
            buildTree(2*idx+1,start,mid,arr);
            buildTree(2*idx+2,mid+1,end,arr);
            segTree[idx]=segTree[idx*2+1]^segTree[idx*2+2];
        }
        int query(int idx,int start,int end,int qStart,int qEnd){
            if(end<qStart || start>qEnd) return 0;
            if(start>=qStart && end<=qEnd) return segTree[idx];
            int mid=start+(end-start)/2;
            int left=query(2*idx+1,start,mid,qStart,qEnd);
            int right=query(2*idx+2,mid+1,end,qStart,qEnd);
            return left^right;

        }
    }
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n=arr.length;
        int q=queries.length;
        SegamentTree obj=new SegamentTree(n);
        obj.buildTree(0,0,n-1,arr);
        int[]ans=new int[q];
        for(int i=0;i<q;i++){
            int a=queries[i][0];
            int b=queries[i][1];
            ans[i]=obj.query(0,0,n-1,a,b);
        }
        return ans;
        
    }
}