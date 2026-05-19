class Solution {
    public int longestStrChain(String[] words) {
        int n=words.length;
        Arrays.sort(words,(a,b)->(a.length()-b.length()));
        int[]dp=new int [n];
        Arrays.fill(dp,1);
        int ans=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(isPredecessor(words[j],words[i])){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
                ans=Math.max(ans,dp[i]);
            }
        }
        return ans;   
    }
    public boolean isPredecessor(String s1,String s2){
        int n1=s1.length();
        int n2=s2.length();
        if(n1+1!=n2) return false;
        int i=0,j=0;
        while(i<n1 && j<n2){
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
            }
            else j++;
        }
        return i==n1;
        

    }
}