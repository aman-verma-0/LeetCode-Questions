class Solution {
    public String decodeString(String s) {
        int n=s.length();
        StringBuilder decoded_string=new StringBuilder("");
        Stack<Character> st=new Stack<>();
        int digit=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch==']'){
                StringBuilder cur=new StringBuilder("");
                boolean charEnds=false;
                StringBuilder dgt=new StringBuilder("");
                while(!st.isEmpty() && st.peek()!='['){
                    cur.insert(0,st.pop());
                }st.pop();
                while(!st.isEmpty() && isDigit(st.peek())){
                    dgt.insert(0,st.pop());
                }
                int freq=Integer.parseInt(dgt.toString());
                String temp=cur.toString();
                while(freq!=1){
                    cur.append(temp);
                    freq--;
                }
                for(int j=0;j<cur.length();j++){
                    st.push(cur.charAt(j));
                }
                
            }else st.push(ch);
        }
        while(!st.isEmpty()){
            decoded_string.insert(0,st.pop());
        }
        return decoded_string.toString();
    }
    public boolean isDigit(char ch){
        return Character.isDigit(ch);
    }
}