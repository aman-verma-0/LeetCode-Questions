class Solution {
    public int minOperations(String s) {

        int changes1 = 0; // pattern 010101
        int changes2 = 0; // pattern 101010

        for(int i = 0; i < s.length(); i++){

            char ch = s.charAt(i);

            // pattern starting with 0
            if(i % 2 == 0){
                if(ch != '0') changes1++;
            }else{
                if(ch != '1') changes1++;
            }

            // pattern starting with 1
            if(i % 2 == 0){
                if(ch != '1') changes2++;
            }else{
                if(ch != '0') changes2++;
            }
        }

        return Math.min(changes1, changes2);
    }
}