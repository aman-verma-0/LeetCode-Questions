class Solution {
    public boolean rotateString(String s, String goal) {
        int l1=s.length();
        int l2=goal.length();
        if(l1!=l2) return false;
        String newString=s+s;
        return newString.contains(goal);
        
    }
}