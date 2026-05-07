class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        List<Integer> ans=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            if(asteroids[i]>0){
                st.push(asteroids[i]);
            }
            else{
                while(!st.isEmpty() && st.peek()<Math.abs(asteroids[i])){
                    st.pop();
                }
                if(!st.isEmpty()&& st.peek()==Math.abs(asteroids[i])){
                    st.pop();
                    continue;
                }
                if(st.isEmpty()){
                    ans.add(asteroids[i]);
                }


            }
        }
        int l=ans.size();
        int stSize=st.size();
        int newSize=l+stSize;
        int[]arr=new int[newSize];
        for(int i=0;i<l;i++){
            arr[i]=ans.get(i);
        }
        int k=newSize-1;
        while(!st.isEmpty()){
            arr[k--]=st.pop();
        }
        return arr;

    }
}