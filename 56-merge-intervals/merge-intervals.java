class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int start=intervals[0][0];
        int prevEnd=intervals[0][1];
        List<int[]> ans=new ArrayList<>();
        for(int i=1;i<n;i++){
            if(prevEnd>=intervals[i][0]){
                prevEnd=Math.max(prevEnd,intervals[i][1]);
            }
            else{
                ans.add(new int[]{start,prevEnd});
                start=intervals[i][0];
                prevEnd=intervals[i][1];
            }
        }
        ans.add(new int[]{start,prevEnd});
        int l=ans.size();
        int[][]arr=new int[l][2];
        for(int i=0;i<l;i++){
            arr[i][0]=ans.get(i)[0];
            arr[i][1]=ans.get(i)[1];
        }
        return arr;
    }
}