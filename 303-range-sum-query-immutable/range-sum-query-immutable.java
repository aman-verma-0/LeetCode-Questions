class NumArray {
    int[]segTree;
    int n;
    public NumArray(int[] nums) {
        n=nums.length;
        segTree=new int[4*n];
        buildTree(nums,0,0,n-1);    
    }
    public void buildTree(int[]nums,int i,int left,int right){
        if(left==right){
            segTree[i]=nums[left];
            return;
        }
        int mid=(left+right)/2;
        buildTree(nums,2*i+1,left,mid);
        buildTree(nums,2*i+2,mid+1,right);
        segTree[i]=segTree[2*i+1]+segTree[2*i+2];

    }
    
    public int sumRange(int left, int right) {
        return query(0,0,n-1,left,right);

        
        
    }
    public int query(int i,int st,int end,int l,int r){
        if(end<l || r<st) return 0;
        if(l<=st && end<=r ) return segTree[i];
        int mid=(st+end)/2;
        int left=query(2*i+1,st,mid,l,r);
        int right=query(2*i+2,mid+1,end,l,r);
        return left+right;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */