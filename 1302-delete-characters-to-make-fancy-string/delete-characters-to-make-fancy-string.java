class Solution {
    public String makeFancyString(String s) {
        int n=s.length();
        StringBuilder sb=new StringBuilder("");
        char prev='0';
        int count=0;
        for(int i=0;i<n;i++){
            char cur=s.charAt(i);
            if(prev!=cur){
                count=1;
                sb.append(cur);
                prev=cur;
            }
            else if(prev==cur && count==1){
                count++;
                sb.append(cur);    
            }
        }
        return sb.toString();
        
    }
}