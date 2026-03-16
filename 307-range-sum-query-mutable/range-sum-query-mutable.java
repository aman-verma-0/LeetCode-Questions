class NumArray {
    int[]segTree;
    int n;

    public NumArray(int[] nums) {
        n=nums.length;
        segTree=new int[4*n];
        buildTree(0,0,n-1,nums);
        
    }
    public void buildTree(int node,int left,int right,int[]nums){
        if(left==right){
            segTree[node]=nums[right];
            return;
        }
        int mid=(left+right)/2;
        buildTree(2*node+1,left,mid,nums);
        buildTree(2*node+2,mid+1,right,nums);
        segTree[node]=segTree[2*node+1]+segTree[2*node+2];
    }
    
    public void update(int index, int val) {
        updateSum(index,val,0,0,n-1);
        
    }
    public void updateSum(int idx,int val,int node,int st,int end){
        if(st==end){
            segTree[node]=val;
            return;
        }
        int mid=(st+end)/2;
        if(idx<=mid){
            updateSum(idx,val,2*node+1,st,mid);
        }
        else updateSum(idx,val,2*node+2,mid+1,end);
        segTree[node]=segTree[2*node+1]+segTree[2*node+2];
    }
    
    public int sumRange(int left, int right) {
        return query(0,0,n-1,left,right);
        
    }
    public int query(int node,int st,int end,int left,int right){
        if(end<left || right<st) return 0;
        if(left<=st && end<=right) return segTree[node];
        int mid=(st+end)/2;
        int lSum=query(2*node+1,st,mid,left,right);
        int rSum=query(2*node+2,mid+1,end,left,right);
        return lSum+rSum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */