class Solution {
    // class SegamentTree{
    //     int[]segTree;
    //     SegamentTree(int n){
    //         segTree=new int[4*n];
    //     }
    //     ///[dgjhkrtyfguhijyredfjhbjn]
    //     void buildTree(int idx,int start,int end){
    //         if(start==end){
    //             int num=start%2;
    //             segTree[idx]=num;
    //             return;
    //         }
    //         int mid=(start+end)/2;
    //         buildTree(2*idx+1,start,mid);
    //         buildTree(2*idx+2,mid+1,end);
    //         segTree[idx]=segTree[2*idx+1]+segTree[2*idx+2];
    //     }
    //     // void update(int idx,int index,int val,int start,int end){
    //     //     if(start==end){
    //     //         segTree[idx]=val;
    //     //         return;
    //     //     }
    //     //     int mid=(start+end)/2;
    //     //     if(index<=mid){
    //     //         update(2*idx+1,index,val,start,mid);
    //     //     }
    //     //     else update(2*idx+2,index,val,mid+1,end);
    //     //     segTree[idx]=segTree[2*idx+1]+segTree[2*idx+2];
    //     // }
    //     int query(int idx,int qStart,int qEnd,int start,int end){
    //         if(end<qStart || start>qEnd) return 0;
    //         if(start>=qStart && end<=qEnd) return segTree[idx];
    //         int mid=(start+end)/2;
    //         int left=query(2*idx+1,qStart,qEnd,start,mid);
    //         int right=query(2*idx+2,qStart,qEnd,mid+1,end);
    //         return left+right;        
            
    //     }
    // }
    public int countOdds(int low, int high) {
        // SegamentTree obj=new SegamentTree(high);
        // obj.buildTree(0,0,high+1);
        // return obj.query(0,low,high,0,high+1);
        int count = (high - low) / 2;
    
        if (low % 2 == 1 || high % 2 == 1) {
            count++;
        }
    
        return count;
    }
}