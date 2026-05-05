class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[]ans=new int[n];
        Stack<int[]> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            int curTemp=temperatures[i];
            while(!st.isEmpty() && st.peek()[0]<=curTemp){
                st.pop();
            }
            if(st.isEmpty()) ans[i]=0;
            else{
                int[]top=st.peek();
                ans[i]=top[1]-i;
            }
            st.push(new int[]{curTemp,i});

        }
        return ans;

        
    }
}