class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        int n1=queries.length;
        int n2=dictionary.length;
        List<String> list=new ArrayList<>();
        
        for(int i=0;i<n1;i++){
            // if(queries[i].length()<=2)
            int edit=0;
            for(int j=0;j<n2;j++){
                String s1=queries[i];
                String s2=dictionary[j];
                if(queries[i].length()==dictionary[j].length()){
                    if(queries[i].length()<=2){
                        list.add(queries[i]);
                        break;
                    }
                    for(int k=0;k<queries[i].length();k++){
                        if(edit>2) break;
                        if(s1.charAt(k)!=s2.charAt(k)) edit++;
                    }
                    if(edit<=2){
                        // if(!list.contains(queries[i])){
                            list.add(queries[i]);
                            break;
                        // }
                    }
                }
                edit=0;
            }
        }
        return list;
    }
}