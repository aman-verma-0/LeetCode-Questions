class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n=encodedText.length();
        int cols=n/rows;
        StringBuilder sb=new StringBuilder("");       
        char[][]mat=new char[rows][cols];
        int idx=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                mat[i][j]=encodedText.charAt(idx++);
            }
        }
        for(int startCol = 0; startCol < cols; startCol++){
            int i = 0;
            int j = startCol;
            
            while(i < rows && j < cols){
                sb.append(mat[i][j]);
                i++;
                j++;
            }
        }
        while(sb.length() > 0 && sb.charAt(sb.length() - 1) == ' '){
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();

        
    }
}