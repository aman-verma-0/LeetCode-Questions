class Solution {
    String []map=new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        int n=digits.length();
        List<String> ans=new ArrayList<>();
        if(n==0) return ans;
        mapAll(0,digits,ans,"");
        return ans;
        
    }
    public void mapAll(int i,String digits,List<String>ans,String current){
        if(i>=digits.length()){
            ans.add(current);
            return;
        }
        int num=digits.charAt(i)-'0';
        String s=map[num];
        for(int ind=0;ind<s.length();ind++){
            mapAll(i+1,digits,ans,current+s.charAt(ind));

        }
        

    }
    
}