class Solution {
    public int minAddToMakeValid(String s) {
        int n=s.length();
        int minReq=0;
        Stack<Character> st=new Stack<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push('(');
            }
            else{
                if(st.isEmpty()) minReq++;
                else st.pop();
            }
        }
        return minReq+st.size();
        
    }
}