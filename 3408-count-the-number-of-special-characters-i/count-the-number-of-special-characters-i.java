class Solution {
    public int numberOfSpecialChars(String word) {
        int n=word.length();
        boolean[]visForLcase=new boolean[26];
        boolean[]visForUcase=new boolean[26];
        for(int i=0;i<n;i++){
            char ch=word.charAt(i);
            if(ch-'A'<26){
                visForUcase[ch-'A']=true;
            }
            else{
                visForLcase[ch-'a']=true;
            }
        }
        int special_letters=0;
        for(int i=0;i<26;i++){
            if(visForLcase[i] && visForUcase[i]) special_letters++;
        }
        return special_letters;

        
    }
}