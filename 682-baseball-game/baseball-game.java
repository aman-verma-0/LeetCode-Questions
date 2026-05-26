class Solution {
    public int calPoints(String[] operations) {
        int n=operations.length;
        int sum=0;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            String cur=operations[i];
            if(cur.equals("C")){
                st.pop();
            }
            else if(cur.equals("D")){
                int Dnum=st.peek()*2;
                st.push(Dnum);
            }
            else if(cur.equals("+")){
                int last=st.pop();
                int secondLast=st.peek();
                int newNum=last+secondLast;
                st.push(last);
                st.push(newNum);
            }
            else{
                st.push(Integer.parseInt(cur));
            }
        }
        while(!st.isEmpty()){
            int cur=st.pop();
            sum+=cur;
        }
        return sum;
    }
}